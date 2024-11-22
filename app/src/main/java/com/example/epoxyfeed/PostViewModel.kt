package com.example.epoxyfeed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.epoxyfeed.models.Post
import com.example.epoxyfeed.models.User
import com.example.epoxyfeed.network.RetrofitInstance
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> get() = _posts

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users


    private val _isLoading = MutableLiveData<Boolean>().apply { value = true }
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun fetchPostsAndUsers() {
        viewModelScope.launch {
            try {

                delay(5000) //simulate network delay
                val fetchedPosts = RetrofitInstance.apiService.getPosts()
                _posts.postValue(fetchedPosts)

                // Fetch users from a different endpoint (as an example)
                val fetchedUsers = RetrofitInstance.apiService.getUsers()
                _users.postValue(fetchedUsers)
            } catch (e: Exception) {
                // Handle exceptions such as network errors or API issues
                Log.e("fetchPostsAndUsers", "Error fetching data: ${e.message}")
            }finally {
                _isLoading.postValue(false) // Hide shimmer
            }
        }
    }
}
