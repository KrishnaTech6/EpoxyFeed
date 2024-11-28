# EpoxyFeed
An Android app that demonstrates the use of **Epoxy** for dynamic list rendering, **Retrofit** for fetching data from a remote API, and various modern UI and performance techniques like **Shimmer Effect**, **SwipeRefreshLayout**, and more. 

This project serves as a learning example for scalable UI design and efficient network integration.


## Features

- **Epoxy** for building complex and dynamic UIs.
- **Retrofit** for fetching posts from the **JSONPlaceholder** API.
- **Glide** for efficient image loading.
- **Shimmer Effect** for loading screen.
- Uses **Epoxy models** and **controllers** to render lists with smooth performance.
- **LiveData** and **ViewModel** for managing UI-related data lifecycle-aware.
- Placeholder images while loading.
- Added fade animation to the post image in Epoxy Model

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

