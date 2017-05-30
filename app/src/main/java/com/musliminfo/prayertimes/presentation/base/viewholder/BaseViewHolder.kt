package com.musliminfo.prayertimes.presentation.base.viewholder

import android.content.res.Resources
import android.support.v7.widget.RecyclerView
import android.view.View

import butterknife.ButterKnife

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    protected val resources: Resources

    init {
        ButterKnife.bind(this, itemView)
        resources = itemView.context.resources
    }

    abstract fun bind(t: T)
}
