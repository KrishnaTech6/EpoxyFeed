package com.example.epoxyfeed.network

import com.example.epoxyfeed.models.Post
import com.example.epoxyfeed.models.User
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("users")
    suspend fun getUsers(): List<User>
}
