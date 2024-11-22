package com.example.epoxyfeed.epoxy

import com.airbnb.epoxy.EpoxyController
import com.example.epoxyfeed.epoxy.epoxymodels.PostItemModel
import com.example.epoxyfeed.epoxy.epoxymodels.SectionHeaderModel
import com.example.epoxyfeed.epoxy.epoxymodels.ShimmerModel
import com.example.epoxyfeed.epoxy.epoxymodels.UserItemModel
import com.example.epoxyfeed.models.Post
import com.example.epoxyfeed.models.User

class PostController : EpoxyController() {
    var posts: List<Post> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    var isLoading: Boolean = true
        set(value) {
            field = value
            requestModelBuild()
        }

    var users: List<User> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {

        if (isLoading){
            repeat(5) { // Show 5 shimmer placeholders
                ShimmerModel()
                    .id("shimmer_$it")
                    .addTo(this)
            }
        }
        else{

            // Filter posts starting with "A"
            val postsStartingWithA = posts.filter { it.title.startsWith("A", ignoreCase = true) }

            if (postsStartingWithA.isNotEmpty()) {
                // Add a title/section header
                SectionHeaderModel("Posts Starting with A").id("a").addTo(this)

                // Add each filtered post
                postsStartingWithA.take(2).forEach { post ->
                    PostItemModel(
                        post.title,
                        post.body,
                        "https://picsum.photos/600/400?random=${post.id}"
                    )
                        .id(post.id)
                        .addTo(this)
                }
            }
            //User Section
            SectionHeaderModel("All Users").id("users").addTo(this)
            users.take(5).forEach { user ->
                UserItemModel(
                    user.name,
                    user.email
                ).id(user.id).addTo(this)
            }

            // Add a title/section header
            SectionHeaderModel("Normal Posts").id("normal_posts").addTo(this)

            posts.forEach { post ->
                PostItemModel(
                    post.title,
                    post.body,
                    "https://picsum.photos/600/400?random=${post.id}"
                ).id(post.id).addTo(this)
            }
        }
    }
}
