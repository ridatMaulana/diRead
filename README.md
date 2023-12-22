# diRead - Multifunctional Journal Application
## Preview
Capstone Project Bangkit Academy 2023 Batch 2 (Mobile Development)<br>
<br>
<img src="https://drive.google.com/uc?export=view&id=1aQAnGaKF-jUnRbtpjvNeDmIjFmDInIfV" alt="dashboard" width="200" height="400">
<img src="https://drive.google.com/uc?export=view&id=1L1QEHejkgnGQpRxzJJX6SQDY14wE-hgd" alt="register" width="200" height="400">
<img src="https://drive.google.com/uc?export=view&id=1aJa8r4CPokvA7tZ0qOuPiT_Vj-RUgh4L" alt="login" width="200" height="400"><br>
<img src="https://drive.google.com/uc?export=view&id=1OF4Hh90eEGPw2KGTvD4mXwT4KfRHuXyZ" alt="home" width="200" height="400">
<img src="https://drive.google.com/uc?export=view&id=1TrXbesqB9Y-oa-fNO591OKGNGCRigXoy" alt="pdfView" width="200" height="400">
<img src="https://drive.google.com/uc?export=view&id=1aki9aIrog2kfRLv8LPjJUAg_uxMYwLXC" alt="selectWord" width="200" height="400"><br>
<img src="https://drive.google.com/uc?export=view&id=1h-piG-qBxgb8Scch8-qsJ3x8PUrzG_h5" alt="wiki" width="200" height="400">
<img src="https://drive.google.com/uc?export=view&id=1gNMNgy-qqKSCt4DizRtm8ZCkqRLG8kwD" alt="collection" width="200" height="400">
<img src="https://drive.google.com/uc?export=view&id=1wL9kreuxh1dBe736jJNlOc4_E-qUE13R" alt="profile" width="200" height="400">

>diRead is an innovative solution application to overcome challenges in accessing and understanding scientific journals. Complex search problems, language limitations, and inefficiencies in text selection and translation are addressed through diRead features. Users can easily find journals by category or keyword, save favorites in the collection menu, and explore journal content with PDF viewing. The text selection feature enables translation and related information, ensuring accessibility and more efficient understanding of scientific information without leaving the application.

## Main feature
### 1. Category Based Search
>diRead provides convenience in searching for journals by sorting them by category. Users can select certain categories, such as technology, science, medical, social, economics, etc. and easily find related journals.

### 2. Keyword Based Search
>The search feature allows users to search for journals based on specific keywords, ensuring more precise results according to user needs.

### 3. Collection Menu
>Users can create their personal journal collections by adding favorite journals to the collection menu. This provides quick and easy access to reread or refer to specific journals.

### 4. Journal Details View
>When users click on a journal, they will see a details view that includes a PDF of the journal. Users can explore the content with ease, even making selections on the text.

### 5. Text Search and Translation
>Users can make selections on PDF journal texts and quickly access translation and dictionary features. This allows them to understand the meaning of foreign language words and know the definition, type, purpose, etc. regarding the selected text without having to leave the application.

## Usage
### Requirement to Run diRead in Android Studio
1. Android Studio Giraffe 2022.3.1
2. Minimum SDK 26/API level 26 (Android 8.0)
3. PC/Laptop
   * Processor: Intel Core i3 (recomended i5 or higher) AMD Ryzen 3 (recomended AMD Ryzen 5 or higher)
   * RAM: 8 GB or higher
   * Disk: minimum 8 GB
   * OS: Microsoft Windows 64 bit

### diRead terms of use
1. Android OS minimum version 8.0 (Oreo)
2. RAM minimum 8GB
3. Internal Storage minimum 32GB
4. Internet Connection

### Installation
#### Install via APK Bundle: 
1. Download APK: [Download]()
- Open the Google Drive link containing the APK.
- Tap the "Download" button to save the APK file to your device.
2. Enable Unknown Sources:
Before installing from sources other than the Play Store, enable "Unknown Sources" in your device settings.
- Navigate to "Settings" > "Security" or "Privacy."
- Find and enable "Unknown Sources" or "Install Apps from Unknown Sources."
3. Open APK File:
- Use a file manager or check your download notifications to locate the downloaded APK file.
4. Start Installation:
- Tap or click the APK file to initiate the installation process.
5. Allow Installation:
- If prompted, grant permission to install by pressing "Install" or "Allow."
6. Wait for Completion:
- Wait for the installation process to finish. Once done, you can open the app.
7. Disable Unknown Sources (Optional):
- For security, you can disable "Unknown Sources" again if needed.


#### Instalation(Via Repository)
1. Clone this repository
2. Open in Android Studio (according to requirements)
3. Connect your device in android studio
   * In virtual device : Click [Run With ADV](https://developer.android.com/studio/run/managing-avds)
   * In real device : Click [Connect With USB Debugging](https://developer.android.com/codelabs/basic-android-kotlin-compose-connect-device#0) or [Connect With Wireless Debugging](https://developer.android.com/studio/run/device)
4. Run your Android Studio: Click [Documentation](https://developer.android.com/studio/run/managing-avds)

### Library
| Library                     | Usage                                                     | Dependencies                                         |
|-----------------------------|-----------------------------------------------------------|------------------------------------------------------|
| AndroidX Core KTX           | Kotlin extensions for AndroidX Core libraries.            | implementation("androidx.core:core-ktx:1.12.0")       |
| AppCompat                   | Backward-compatible support for modern Android features.  | implementation("androidx.appcompat:appcompat:1.6.1")   |
| Material Design             | Material Components for Android UI design.                | implementation("com.google.android.material:material:1.11.0") |
| ConstraintLayout            | Declarative UI layout manager for Android.                | implementation("androidx.constraintlayout:constraintlayout:2.1.4") |
| DataStore Core               | Jetpack DataStore for persistent data storage.            | implementation("androidx.datastore:datastore-core:1.0.0") |
| Navigation Fragment          | Navigation library for navigating between destinations.  | implementation("androidx.navigation:navigation-fragment:2.7.6") |
| JUnit                       | Testing framework for unit tests.                         | testImplementation("junit:junit:4.13.2")               |
| Android Test JUnit          | JUnit extensions for Android instrumented tests.         | androidTestImplementation("androidx.test.ext:junit:1.1.5") |
| Espresso Core               | UI testing framework for Android.                         | androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1") |
| Lifecycle LiveData KTX       | Kotlin extensions for LiveData in Android lifecycle components. | implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2") |
| Retrofit                    | Type-safe HTTP client for Android networking.             | implementation("com.squareup.retrofit2:retrofit:2.9.0") |
| Retrofit Gson Converter      | Gson converter for Retrofit to serialize/deserialize JSON.| implementation("com.squareup.retrofit2:converter-gson:2.9.0") |
| OkHttp Logging Interceptor   | Interceptor for logging HTTP requests and responses.      | implementation("com.squareup.okhttp3:logging-interceptor:4.11.0") |
| DataStore Core Android       | Android-specific extensions for Jetpack DataStore.       | implementation("androidx.datastore:datastore-core-android:1.1.0-alpha07") |
| DataStore Preferences        | Preferences storage using Jetpack DataStore.              | implementation("androidx.datastore:datastore-preferences:1.0.0") |
| Lifecycle ViewModel KTX      | Kotlin extensions for ViewModels in Android lifecycle components. | implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2") |
| Activity KTX                | Kotlin extensions for AndroidX Activity library.          | implementation ("androidx.activity:activity-ktx:1.8.2") |
| Lifecycle Extensions         | Deprecated extensions for Android lifecycle components.   | implementation("androidx.lifecycle:lifecycle-extensions:2.2.0") |
| CircleImageView             | Circular ImageView for Android.                           | implementation ("de.hdodenhof:circleimageview:3.1.0") |
| Fragment KTX                | Kotlin extensions for AndroidX Fragment library.          | implementation ("androidx.fragment:fragment-ktx:1.6.2") |
