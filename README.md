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
| Library                              | Usage                                                                                                                                                             | Dependencies                                                                |
|--------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
| Android KTX                          | To provide Kotlin extensions for core Android components such as collections, files, preferences, and more                                                        | implementation 'androidx.core:core-ktx:1.8.0'                               |
| Lifecycle                            | To enable observing and responding to life cycle changes of Android components such as activities and fragments.                                                  | implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.6.1'             |
| Activity Compose                     | To provide Activity-ktx, which is part of Jetpack Compose, for easy integration of Activity with Compose UI.                                                      | implementation 'androidx.activity:activity-compose:1.5.1'                   |
| Compose UI                           | To provide UI basics on Jetpack Compose and layout system to build a declarative and responsive user interface.                                                   | implementation 'androidx.compose.ui:ui'                                     |
| Compose UI Graphic                   | To provide functions and tools for drawing and manipulating graphics within Jetpack Compose.                                                                      | implementation 'androidx.compose.ui:ui-graphics'                            |
| Compose Tooling Preview              | To provide development tools and previews to help develop interfaces with Jetpack Compose.                                                                        | implementation 'androidx.compose.ui:ui-tooling-preview'                     |
| Jetpack Compose Material 3           | To provide Material Design version 3 components for Jetpack Compose, including components such as buttons, cards, text, and more.                                 | implementation 'androidx.compose.material3:material3'                       |
| JUnit                                | To provide Material Design version 3 components for Jetpack Compose, including components such as buttons, cards, text, and more.                                 | testImplementation 'junit:junit:4.13.2'                                     |
| JUnit Test                           | This library is part of AndroidX Test and provides extensions to the JUnit unit testing framework for Android.                                                    | androidTestImplementation 'androidx.test.ext:junit:1.1.5'                   |
| AndroidX Test                        | To provide a powerful and expressive functional testing (UI) framework for Android application testing.                                                           | androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'      |
| Compose JUnit Test                   | To provide testing tools and utilities for UI testing with Jetpack Compose using JUnit 4.                                                                         | androidTestImplementation 'androidx.compose.ui:ui-test-junit4'              |
| Compose Tooling                      | To provide development tools and utilities to assist development with Jetpack Compose.                                                                            | debugImplementation 'androidx.compose.ui:ui-tooling'                        |
| Compose Test Manifest                | To provide the manifest required to run tests with Jetpack Compose.                                                                                               | debugImplementation 'androidx.compose.ui:ui-test-manifest'                  |
| Jetpack Compose Material Design Icon | To provide extended Material Design icons for use in applications that use Jetpack Compose.                                                                       | implementation "androidx.compose.material:material-icons-extended:1.4.3"    |
| Jetpack Compose Navigation           | To provide integration between Jetpack Compose and Android Navigation Components, allowing for integrated and easy-to-manage user interface navigation.           | implementation "androidx.navigation:navigation-compose:2.5.3"               |
| Pager Component For Jetpack Compose  | To provide a Pager component for Jetpack Compose, which enables views with swipe navigation such as page views or carousel views.                                 | implementation "com.google.accompanist:accompanist-pager:0.30.1"            |
| Pager Indicator For Jetpack Compose  | To provide a pager indicator for Jetpack Compose, which can be used to display indicators such as dots or arrows to show the current position in the pager view.  | implementation "com.google.accompanist:accompanist-pager-indicators:0.30.1" |
| Retrofit                             | This library is a powerful and lightweight HTTP client for Android and Java, which allows communication with servers using the HTTP protocol and REST API.        | implementation 'com.squareup.retrofit2:retrofit:2.9.0'                      |
| GSON                                 | This library is a Retrofit converter that uses Gson to convert JSON responses from the server into Java/Kotlin objects.                                           | implementation "com.squareup.retrofit2:converter-gson:2.9.0"                |
| OKHTTP3                              | This library is an OkHttp interceptor used to view and log HTTP requests and responses for troubleshooting and debugging purposes.                                | implementation "com.squareup.okhttp3:logging-interceptor:4.9.0"             |
| View Model For Jetpack Compose       | This library provides integration between Jetpack Compose and the ViewModel architecture, allowing the use of ViewModels in Compose UI components.                | implementation "androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1"       |
| Preference                           | This library provides Android preferences as a component of the Jetpack architecture, which allows easy organisation of applications and use of user preferences. | implementation "androidx.preference:preference-ktx:1.2.0"                   |
| Data Store                           | This library is part of the Jetpack DataStore and provides a more secure and efficient data storage mechanism than traditional Android preferences.               | implementation "androidx.datastore:datastore-preferences:1.0.0"             |
| Live Data                            | This library provides Kotlin extensions for the Jetpack LiveData architectural component, which enables reactive observation of data in Android applications.     | implementation "androidx.compose.runtime:runtime-livedata:1.4.3"            |
| Coil Compose                         | This library is an asynchronous image loader library for Android, which provides smooth and efficient image display in apps that use Jetpack Compose.             | implementation("io.coil-kt:coil-compose:1.4.0")                             |                                                                         |
