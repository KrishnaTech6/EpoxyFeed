# EpoxyFeed
An Android app using Epoxy for dynamic list rendering with Retrofit to fetch posts from a remote API (JSONPlaceholder). It demonstrates how to efficiently use Epoxy models and controllers for scalable UI, integrate images with Glide, and manage data binding, making the app flexible and maintainable.
This is an example app to learn and use Epoxy Controller and models 

## Features

- **Epoxy** for building complex and dynamic UIs.
- **Retrofit** for fetching posts from the **JSONPlaceholder** API.
- **Glide** for efficient image loading.
- **Shimmer Effect** for loading screen.
- Uses **Epoxy models** and **controllers** to render lists with smooth performance.
- **LiveData** and **ViewModel** for managing UI-related data lifecycle-aware.
- Placeholder images while loading.
- Added fade animation to the post image in Epoxy Model

## Prerequisites

- Android Studio
- Kotlin
- Android SDK
- Retrofit, Epoxy, Glide dependencies

## Screenshots 

<p align="center">
  <img src="https://github.com/user-attachments/assets/e7608530-26a7-4d63-ab86-0eadd5a4d487" width="200" />
  <img src="https://github.com/user-attachments/assets/6bc5f9c2-57ee-492f-a893-f685e96cced3" width="200" />
  <img src="https://github.com/user-attachments/assets/fe9dc9bc-526b-4b61-95a5-899cfa8bd972" width="200" />
</p>


### Dependencies 
```
dependencies {
    implementation ("com.airbnb.android:epoxy:4.6.1")  // Epoxy
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")  // Retrofit
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")  // Gson converter for Retrofit
    implementation ("com.github.bumptech.glide:glide:4.11.0")  // Glide
    implementation ("com.facebook.shimmer:shimmer:0.5.0")
}
```

