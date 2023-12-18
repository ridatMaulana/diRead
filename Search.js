import React, { useEffect } from 'react';
import ml5 from 'ml5';

function App() {
  useEffect(() => {
    // Load the pre-trained model
    ml5.text('tfidf', 'model/tfidf_model.json', modelLoaded);

    // Cleanup on unmount
    return () => ml5.tf.dispose();
  }, []);

  // Callback function when the model is loaded
  function modelLoaded() {
    // Call the function with a keyword
    getKeywordRecommendations("Lahan Uang");
  }

  // Function to get keyword recommendations
  function getKeywordRecommendations(keyword) {
    // Mock book data
    const book = {
      Judul: ["Book 1", "Book 2", "Book 3", "Book 4"],
      Keyword: ["Keyword 1", "Keyword 2", "Keyword 3", "Keyword 4"],
      Abstrak: ["Abstract 1", "Abstract 2", "Abstract 3", "Abstract 4"]
    };

    // Vectorize the input keyword
    const inputVector = ml5.tf.idfVectorizer.transform([keyword]);

    // Calculate similarities
    const keywordSimilarities = ml5.tf.cosineSimilarity(keywordMatrix, inputVector);

    // Get indices of top 3 similar books
    const similarBooks = ml5.tf.topk(keywordSimilarities, 3).indices.arraySync();

    // Log the book titles
    console.log("Keyword Recommendations:");
    similarBooks.forEach(index => {
      console.log(book.Judul[index]);
    });
  }

  // Mock keyword matrix
  const keywordMatrix = ml5.tf.tidy(() => {
    const tfidfVectorizer = ml5.tf.idfVectorizer;
    return tfidfVectorizer.transform(book.Judul.map((title, i) => `${title} ${book.Keyword[i]} ${book.Abstrak[i]}`));
  });

  return (
    <div className="App">
      <h1>Keyword Recommendations App</h1>
    </div>
  );
}

export default App;