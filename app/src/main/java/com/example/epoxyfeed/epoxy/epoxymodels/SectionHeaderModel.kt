package com.example.epoxyfeed.epoxy.epoxymodels

import android.view.View
import android.view.ViewParent
import android.widget.TextView
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.epoxyfeed.R

class SectionHeaderModel(
    private val title: String
) : EpoxyModelWithHolder<SectionHeaderModel.Holder>() {

    override fun getDefaultLayout() = R.layout.item_section_header

    override fun createNewHolder(parent: ViewParent): Holder? {
        return Holder()
    }

    override fun bind(holder: Holder) {
        holder.titleTextView.text = title
    }

    class Holder : EpoxyHolder() {
        lateinit var titleTextView: TextView

        override fun bindView(itemView: View) {
            titleTextView = itemView.findViewById(R.id.tv_header)
        }
    }
}