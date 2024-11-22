package com.example.epoxyfeed.epoxy.epoxymodels

import android.view.View
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.example.epoxyfeed.R

class PostItemModel(
    private val title: String,
    private val body: String,
    private val imageUrl: String
) : EpoxyModelWithHolder<PostItemModel.Holder>() {

    override fun getDefaultLayout() = R.layout.item_post
    override fun createNewHolder(parent: ViewParent): Holder? {
        return Holder() //Create a new instance of a holder
    }

    override fun bind(holder: Holder) {
        holder.itemView.alpha = 0f
        holder.itemView.animate()
            .alpha(1f)
            .setDuration(500)
            .start()
        holder.titleTextView.text = title
        holder.bodyTextView.text = body
        Glide.with(holder.postImageView.context)
            .load(imageUrl)
            .placeholder(R.drawable.ic_placeholder)
            .into(holder.postImageView)
    }

    override fun unbind(holder: Holder) {
        super.unbind(holder)
        holder.itemView.clearAnimation()
    }

    class Holder : EpoxyHolder() {
        lateinit var itemView: View
        lateinit var postImageView: ImageView
        lateinit var titleTextView: TextView
        lateinit var bodyTextView: TextView

        override fun bindView(itemView: View) {
            this.itemView = itemView
            postImageView = itemView.findViewById(R.id.postImageView)
            titleTextView = itemView.findViewById(R.id.titleTextView)
            bodyTextView = itemView.findViewById(R.id.bodyTextView)
        }
    }
}
