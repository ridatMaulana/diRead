from flask import Flask, request, jsonify
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity
import numpy as np
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split
from sklearn.neighbors import NearestNeighbors
import tensorflow as tf
import pandas as pd

app = Flask(__name__)

basePath = 'C:/Users/ASUS/Documents/Code/Capstone'
book = pd.read_csv(basePath+'/Buku.csv')

# db_username = 'your_username'
# db_password = 'your_password'
# db_host = 'your_host'
# db_name = 'your_database_name'

# # Replace 'your_database_type' with the type of your database (e.g., 'mysql', 'postgresql', 'sqlite', etc.)
# db_type = 'your_database_type'

# # Create the database connection string
# db_connection_str = f'{db_type}://{db_username}:{db_password}@{db_host}/{db_name}'

# # Create the database engine
# engine = create_engine(db_connection_str)

# # Specify the SQL query to fetch data from the database
# sql_query = "SELECT Judul, Keyword, Abstrak, TahunTerbit FROM YourTableName"

# # Load data from the database into a pandas DataFrame
# book = pd.read_sql(sql_query, engine)

# # Drop unnecessary columns
book.drop(axis=1, labels=['P-ISSN', 'Pdf', 'Reference'], inplace=True)

tfidf_vectorizer = TfidfVectorizer()
keyword_matrix = tfidf_vectorizer.fit_transform(book['Judul'] + ' ' + book['Keyword'] + ' ' + book['Abstrak'] + ' ' + book['TahunTerbit'].astype(str))

book['BookID'] = range(len(book))
modelK = NearestNeighbors(n_neighbors=5, metric='cosine')
modelK.fit(keyword_matrix)

def get_keyword_recommendations(keyword, year):
    input_vector = tfidf_vectorizer.transform([keyword + " " + str(year)])
    _, indices = modelK.kneighbors(input_vector)
    similar_books = indices.flatten()
    top_books = book.iloc[similar_books].head(5)
    return top_books.to_dict(orient='records')

@app.route('/recommendations', methods=['POST'])
def get_recommendations():
    data = request.get_json()
    keyword = data.get('keyword', 'String')
    tahun = data.get('tahun', 'String')
    keyword_recommendations = get_keyword_recommendations(keyword, tahun)
    return jsonify({"recommendations": keyword_recommendations})

scaler = StandardScaler()
train_data, test_data = train_test_split(book, test_size=0.2, random_state=42)

tfdf = TfidfVectorizer()
X_train = tfdf.fit_transform(train_data['Judul'])
X_test = tfdf.transform(test_data['Judul'])

y_train = scaler.fit_transform(train_data['TahunTerbit'].values.reshape(-1, 1))
y_test = scaler.transform(test_data['TahunTerbit'].values.reshape(-1, 1))

# Define and train the model
model = tf.keras.Sequential([
    tf.keras.layers.Dense(128, activation='relu', input_shape=(X_train.shape[1],)),
    tf.keras.layers.Dense(1)
])

model.compile(optimizer='adam', loss='mse', metrics=['mae'])
model.fit(X_train.toarray(), y_train, epochs=10, batch_size=32, validation_split=0.2)

# API endpoint for predictions
@app.route('/predict', methods=['POST'])
def predict():
    data = request.get_json(force=True)
    input_data = tfdf.transform([data['judul']])
    prediction = model.predict(input_data.toarray())
    predicted_year = scaler.inverse_transform(prediction)[0][0]
    year = int(predicted_year)
    return jsonify({'predicted_year': year})

if __name__ == '__main__':
    app.run(debug=True)