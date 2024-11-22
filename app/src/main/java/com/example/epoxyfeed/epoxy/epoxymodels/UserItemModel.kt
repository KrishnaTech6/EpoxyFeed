package com.example.epoxyfeed.epoxy.epoxymodels

import android.view.View
import android.view.ViewParent
import android.widget.TextView
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.epoxyfeed.R

class UserItemModel(
    private val name: String,
    private val email: String
) : EpoxyModelWithHolder<UserItemModel.Holder>() {

    override fun getDefaultLayout() = R.layout.item_user

    override fun createNewHolder(parent: ViewParent): Holder? {
        return Holder()
    }

    override fun bind(holder: Holder) {
        holder.nameTextView.text = name
        holder.emailTextView.text = email
    }

    class Holder : EpoxyHolder() {
        lateinit var nameTextView: TextView
        lateinit var emailTextView: TextView

        override fun bindView(itemView: View) {
            nameTextView = itemView.findViewById(R.id.nameTextView)
            emailTextView = itemView.findViewById(R.id.emailTextView)
        }
    }
}
