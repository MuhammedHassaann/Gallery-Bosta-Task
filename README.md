
# My Gallery

"My Gallery" is a minimalist Android app that dynamically fetches a random user's details and albums using Retrofit. The home screen presents the user's information, while selecting an album navigates to a secondary screen displaying all images with a search bar for easy filtering by title. Tapping on an image leads to a dedicated preview screen equipped with zoom functionality. The app also supports seamless sharing of images with other applications, enhancing user interaction and engagement.


![logo](https://github.com/MuhammedHassaann/Gallery-Bosta-Task/assets/87133323/138ea322-46a6-452c-ba2f-1584419c8a5f)


## Tools and Technologies
* [Kotlin](https://kotlinlang.org/), the programming language used
* [Jetpack Compose](https://developer.android.com/jetpack/compose) is a modern toolkit for building native UI
* [Compose Material 3](https://developer.android.com/jetpack/androidx/releases/compose-material3) Pre-made styles and components for sleek Android app design in Jetpack Compose.
* [Version Catalog](https://developer.android.com/build/migrate-to-catalogs) enable you to add and maintain dependencies and plugins in a scalable way.
* [MVVM](https://www.toptal.com/android/android-apps-mvvm-with-clean-architecture) is a design pattern that separates an application into three components—Model (data and business logic), View (user interface), and ViewModel (mediator between Model and View), promoting a clean and organized architecture.
* [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines) for asynchronous APIs
* [AndroidX Libraries](https://developer.android.com/jetpack/androidx) that are part of Android Jetpack
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) for communicating between the view and the model layers
* [Android Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) for handling the lifecycle of architecture components
* [Hilt](https://dagger.dev/hilt/) for implementing Dependency Injection with Dagger Hilt
* [Retrofit2](https://github.com/square/retrofit) for making network requests
* [Gson](https://github.com/google/gson) for parsing network responses and JSON files
* [Coil](https://github.com/coil-kt/coil) for loading images with URL
* [Lottie](https://github.com/airbnb/lottie-android) Render After Effects animations natively on Android



## Demo
### Dark Mode

| Splash Screen | Home Screen     | Album Screen                |
| :-------- | :------- | :------------------------- |
| ![ezgif-4-6621a68b2c](https://github.com/MuhammedHassaann/Gallery-Bosta-Task/assets/87133323/337df7aa-2932-4a4c-b0df-dc10e9833d20) | ![home-screen](https://github.com/MuhammedHassaann/Gallery-Bosta-Task/assets/87133323/956a7cd5-8b59-445e-acbe-eeb351064adf) | ![album-screen](https://github.com/MuhammedHassaann/Gallery-Bosta-Task/assets/87133323/ee1a73a7-0fe3-4163-9926-17190b24c53f) |

| Image Preview Screen | Share Image With Other Apps     | No Internet                |
| :-------- | :------- | :------------------------- |
| ![image-screen](https://github.com/MuhammedHassaann/Gallery-Bosta-Task/assets/87133323/f7f67761-ec52-4cb3-abac-0861e970080c) | ![share-image](https://github.com/MuhammedHassaann/Gallery-Bosta-Task/assets/87133323/6ae45613-c025-48e9-8490-8a37a9dab2fe) | ![no-internet](https://github.com/MuhammedHassaann/Gallery-Bosta-Task/assets/87133323/4408f2af-28dd-4b93-9c27-3bc7f400a28f) |

### Light Mode

| Splash Screen | Home Screen     | Album Screen                |
| :-------- | :------- | :------------------------- |
| ![splash-day](https://github.com/MuhammedHassaann/Gallery-Bosta-Task/assets/87133323/e509c357-751c-481f-815c-136fe31f1b46) | ![home-day](https://github.com/MuhammedHassaann/Gallery-Bosta-Task/assets/87133323/f4597f65-3ee8-48cb-ae88-30b2ef370cb3) | ![album-day](https://github.com/MuhammedHassaann/Gallery-Bosta-Task/assets/87133323/9c418589-9028-4436-b076-37bba0956979) |

| Image Preview Screen | Share Image With Other Apps     | No Internet                |
| :-------- | :------- | :------------------------- |
| ![image-day](https://github.com/MuhammedHassaann/Gallery-Bosta-Task/assets/87133323/c553a7ee-9a4a-42d8-b5ec-c7d95ab4245b) | ![share-day](https://github.com/MuhammedHassaann/Gallery-Bosta-Task/assets/87133323/72508280-7fec-41ed-bafb-18d18dd1dd1d) | ![no-internet-day](https://github.com/MuhammedHassaann/Gallery-Bosta-Task/assets/87133323/5d5bef55-218b-4f0d-bdbd-8afa90a38ea9) |

## API Reference

#### Base URL
To make sure the app works add this to your "local.properties" file.
```http
  BASE_URL = "https://jsonplaceholder.typicode.com"
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `BASE_URL` | `string` | **Required**. Base URL |

### API Endpoints
#### Get users

```http
  GET /users
```
#### Get Albums

```http
  GET /albums/{userId}
```
#### Get Photos

```http
  GET /photos/{albumId}
```




## Support

For support, email muhammed.hassaann@gmail.com 

