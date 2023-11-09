
# My Gallery

"My Gallery" is a minimalist Android app that dynamically fetches a random user's details and albums using Retrofit. The home screen presents the user's information, while selecting an album navigates to a secondary screen displaying all images with a search bar for easy filtering by title. Tapping on an image leads to a dedicated preview screen equipped with zoom functionality. The app also supports seamless sharing of images with other applications, enhancing user interaction and engagement.


![Logo](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/th5xamgrr6se0x5ro4g6.png)


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

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `BASE_URL` | `string` | **Required**. Base URL |

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `BASE_URL` | `string` | **Required**. Base URL |

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `BASE_URL` | `string` | **Required**. Base URL |


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

