package com.example.epoxyfeed

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.airbnb.epoxy.EpoxyRecyclerView
import com.example.epoxyfeed.epoxy.PostController
import com.example.epoxyfeed.utils.AndroidConnectivityObserver
import com.example.epoxyfeed.utils.PostViewModelFactory
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel: PostViewModel by viewModels {
        PostViewModelFactory(AndroidConnectivityObserver(applicationContext))
    }
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

        val tvIsInternetAvailable = findViewById<TextView>(R.id.no_internet)
        val refreshLayout = findViewById<SwipeRefreshLayout>(R.id.main)
        val epoxyRecyclerView: EpoxyRecyclerView = findViewById(R.id.epoxyRecyclerView)
        epoxyRecyclerView.setController(controller)

        viewModel.posts.observe(this) { posts ->
            controller.posts = posts
        }
        viewModel.isLoading.observe(this) { isLoading ->
            controller.isLoading = isLoading
            refreshLayout.isRefreshing = isLoading
        }
        viewModel.users.observe(this) { users ->
            controller.users = users
        }

        lifecycleScope.launch{
            viewModel.isConnected.collectLatest {
                if(!it) tvIsInternetAvailable.isVisible = true
                else tvIsInternetAvailable.isVisible = false
            }
        }

        refreshLayout.setOnRefreshListener{
            viewModel.fetchPostsAndUsers()
        }
        refreshLayout.setProgressViewOffset(
            true,  // Scale the animation
            50,   // Start position (in pixels)
            200    // End position (in pixels)
        )


        viewModel.fetchPostsAndUsers()
    }

}