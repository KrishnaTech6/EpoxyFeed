package com.example.epoxyfeed

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.epoxyfeed.epoxy.PostController

class MainActivity : AppCompatActivity() {
    private val viewModel: PostViewModel by viewModels()
    private val controller = PostController()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val epoxyRecyclerView: EpoxyRecyclerView = findViewById(R.id.epoxyRecyclerView)
        epoxyRecyclerView.setController(controller)

        viewModel.posts.observe(this) { posts ->
            controller.posts = posts
        }
        viewModel.isLoading.observe(this) { isLoading ->
            controller.isLoading = isLoading
        }
        viewModel.users.observe(this) { users ->
            controller.users = users
        }

        viewModel.fetchPostsAndUsers()
    }

}