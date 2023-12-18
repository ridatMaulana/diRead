from flask import Flask, request, jsonify
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity
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
# book.drop(axis=1, labels=['P-ISSN', 'Pdf', 'Reference'], inplace=True)

book['BookID'] = range(len(book))
tfidf_vectorizer = TfidfVectorizer()
keyword_matrix = tfidf_vectorizer.fit_transform(book['Judul'] + ' ' + book['Keyword'] + ' ' + book['Abstrak'] + ' ' + book['TahunTerbit'].astype(str))

def get_keyword_recommendations(keyword, year):
    input_vector = tfidf_vectorizer.transform([keyword + " " + str(year)])
    keyword_similarities = cosine_similarity(keyword_matrix, input_vector)
    book['Similarity'] = keyword_similarities.flatten()
    sorted_books = book.sort_values(by=['Similarity', 'TahunTerbit'], ascending=[False, False])
    top_books = sorted_books.head(5)
    return top_books.to_dict(orient='records')

@app.route('/recommendations', methods=['POST'])
def get_recommendations():
    data = request.get_json()
    keyword = data.get('keyword', 'String')
    tahun = data.get('tahun', 'String')
    keyword_recommendations = get_keyword_recommendations(keyword, tahun)
    return jsonify({"recommendations": keyword_recommendations})

if __name__ == '__main__':
    app.run(debug=True)