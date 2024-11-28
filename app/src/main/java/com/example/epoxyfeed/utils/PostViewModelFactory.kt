package com.example.epoxyfeed.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.epoxyfeed.PostViewModel

class PostViewModelFactory(private val argument: ConnectivityObserver) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            return PostViewModel(argument) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
