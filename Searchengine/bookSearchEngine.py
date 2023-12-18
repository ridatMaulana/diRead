from flask import Flask, request, jsonify
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.metrics.pairwise import cosine_similarity
import pandas as pd

app = Flask(__name__)

basePath = 'C:/Users/ASUS/Documents/Code/Capstone'
book = pd.read_csv(basePath+'/Buku.csv')
book.drop(axis=1, labels=['P-ISSN', 'Pdf', 'Reference'], inplace=True)
book['BookID'] = range(len(book))
tfidf_vectorizer = TfidfVectorizer()
keyword_matrix = tfidf_vectorizer.fit_transform(book['Judul'] + ' ' + book['Keyword'] + ' ' + book['Abstrak'] + ' ' + book['TahunTerbit'].astype(str))

def get_keyword_recommendations(keyword, year):
    input_vector = tfidf_vectorizer.transform([keyword + " " + str(year)])
    keyword_similarities = cosine_similarity(keyword_matrix, input_vector)
    book['Similarity'] = keyword_similarities.flatten()
    sorted_books = book.sort_values(by=['Similarity', 'TahunTerbit'], ascending=[False, False])
    top_books = sorted_books.head(5)['Judul']
    return top_books.tolist()

@app.route('/recommendations', methods=['POST'])
def get_recommendations():
    data = request.get_json()
    keyword = data.get('keyword', 'String')
    tahun = data.get('tahun', 'String')
    keyword_recommendations = get_keyword_recommendations(keyword, tahun)
    return jsonify({"recommendations": keyword_recommendations})

if __name__ == '__main__':
    app.run(debug=True)