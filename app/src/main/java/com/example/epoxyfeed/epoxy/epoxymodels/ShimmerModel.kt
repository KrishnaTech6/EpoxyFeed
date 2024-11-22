package com.example.epoxyfeed.epoxy.epoxymodels

import android.view.View
import android.view.ViewParent
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.epoxyfeed.R
import com.facebook.shimmer.ShimmerFrameLayout

class ShimmerModel : EpoxyModelWithHolder<ShimmerModel.Holder>() {

    override fun getDefaultLayout() = R.layout.item_shimmer_post

    class Holder : EpoxyHolder() {
        lateinit var shimmerLayout: ShimmerFrameLayout

        override fun bindView(itemView: View) {
            shimmerLayout = itemView.findViewById(R.id.shimmerLayout)
        }
    }

    override fun createNewHolder(parent: ViewParent): Holder = Holder()

    override fun bind(holder: Holder) {
        holder.shimmerLayout.startShimmer()
    }

    override fun unbind(holder: Holder) {
        holder.shimmerLayout.stopShimmer()
    }
}
