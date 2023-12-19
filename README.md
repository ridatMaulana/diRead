# diRead
## MACHINE LEARNING FOR MINI SEARCH ENGINE
### This is the machine learning part for the diRead application.

> This machine learning consists of 2 models, namely a model for searching (Search Engine) and a model for matching or predicting titles with the year of publication. [The dataset](https://github.com/ridatMaulana/diRead/blob/a8ce1bed0d791c5f6201f78b15a0d710e616965c/Buku.csv) used in machine learning contains P-ISSN, E-ISSN, Keyword, Judul, Penulis, Tahun Terbit, Publisher, Volume, No. Edisi, Jumlah Halaman, File Pdf, Reference, and Abstrak. For analysis of the model creation carried out, you can see it in this [file](https://github.com/ridatMaulana/diRead/blob/a8ce1bed0d791c5f6201f78b15a0d710e616965c/Books.ipynb).

>In deploying the model, machine learning uses the [flask](https://flask.palletsprojects.com/en/3.0.x/) package. When deploying the files used can be seen [here](https://github.com/ridatMaulana/diRead/blob/a8ce1bed0d791c5f6201f78b15a0d710e616965c/bookSearchEngine.py). An example of local deployment can be seen in the image below.

> Running File using **Python BookSearchEngine**

#### Predict Year

#### Recommendation Journal