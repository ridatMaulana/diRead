# diRead
## MACHINE LEARNING FOR MINI SEARCH ENGINE
### This is the machine learning part for the diRead application.

> This machine learning consists of 2 models, namely a model for searching (Search Engine) and a model for matching or predicting titles with the year of publication. [The dataset](https://github.com/ridatMaulana/diRead/blob/a8ce1bed0d791c5f6201f78b15a0d710e616965c/Buku.csv) used in machine learning contains P-ISSN, E-ISSN, Keyword, Judul, Penulis, Tahun Terbit, Publisher, Volume, No. Edisi, Jumlah Halaman, File Pdf, Reference, and Abstrak. For analysis of the model creation carried out, you can see it in this [file](https://github.com/ridatMaulana/diRead/blob/a8ce1bed0d791c5f6201f78b15a0d710e616965c/Books.ipynb).

#### Gatharing Preparing Data
>The data we have obtained came from [Google Scholar](https://scholar.google.com/) by searching journal articles one by one. The data we managed to collect was 30 rows with 13 columns.

#### Prepocessing Data
>We have checked the dataset to ensure there is no missing data (NaN) or duplicates. Next, we deleted several columns that would not be used in the analysis.

#### Exploratory Data Analysis
>We visualize the data to see the amount of data in percentages and the correlation between features.

#### Build Models
>The predict year model, we use DNN (Deep Neural Network) because the data is categorical. We use 2 layers with 32 outputs based on personality classes in the dataset. For the recommendation(Search Engine) we use K-nearest Neighbors Algorithm model to get data that is similar to the given keywords.

#### Test Models
>After building models, we evaluate model performance using evaluation metrics and techniques such as encross-validation. Then, We try to make our own simulation to test whether the model we have is good.

#### Deployment
>In deploying the model, machine learning uses the [flask](https://flask.palletsprojects.com/en/3.0.x/) package. When deploying the files used can be seen [here](https://github.com/ridatMaulana/diRead/blob/a8ce1bed0d791c5f6201f78b15a0d710e616965c/bookSearchEngine.py). An example of a local implementation can be seen below.

##### Running File using **Python BookSearchEngine.py**

##### Predict Year
![Predict Year Image](../model-recommendation/Predict.png)

##### Recommendation Journal
![Recommendation Journal Image](../model-recommendation/Recommendation.png)