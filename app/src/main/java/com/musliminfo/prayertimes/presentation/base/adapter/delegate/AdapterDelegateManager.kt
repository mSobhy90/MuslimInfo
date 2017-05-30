package com.musliminfo.prayertimes.presentation.base.adapter.delegate

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import java.util.*

class AdapterDelegateManager<T> {

    private val delegateList = ArrayList<AdapterDelegate<T>>()

    fun addDelegate(delegate: AdapterDelegate<T>): AdapterDelegateManager<T> {
        delegateList.add(delegate)
        return this
    }

    fun getItemViewType(item: T, position: Int): Int {
        for (adapterDelegate in delegateList) {
            if (adapterDelegate.isForViewType(item, position)) {
                return adapterDelegate.itemViewType
            }
        }

        return NO_DELEGATE_FOUND
    }

    fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        for (adapterDelegate in delegateList) {
            if (adapterDelegate.itemViewType == viewType) {
                return adapterDelegate.onCreateViewHolder(viewGroup)
            }
        }

        // if no delegate matches the viewType, use the EmptyItemViewHolder
        return EmptyItemViewHolder.create(viewGroup)
    }

    fun onBindViewHolder(item: T, position: Int,
                         viewHolder: RecyclerView.ViewHolder) {
        val viewType = viewHolder.itemViewType

        for (adapterDelegate in delegateList) {
            if (adapterDelegate.itemViewType == viewType) {
                adapterDelegate.onBindViewHolder(item, position, viewHolder)
                break
            }
        }
    }

    fun clearDelegates() {
        delegateList.clear()
    }

    /**
     * Unknown items in RecyclerView.Adapter. An item connected to this ViewHolder does not get drawn on the
     * RecyclerView.
     */
    private class EmptyItemViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        companion object {

            fun create(viewGroup: ViewGroup): EmptyItemViewHolder {
                val emptyView = View(viewGroup.context)
                emptyView.layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT)
                emptyView.setPadding(0, 0, 0, 0)
                return EmptyItemViewHolder(emptyView)
            }
        }
    }

    companion object {

        private val NO_DELEGATE_FOUND = -1
    }
}
