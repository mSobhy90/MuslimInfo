package com.musliminfo.prayertimes.presentation.base.adapter.delegate

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

abstract class AdapterDelegate<T> protected constructor(
        /**
         * Get the view type integer. Must be unique within every Adapter

         * @return the integer representing the view type
         */
        val itemViewType: Int) {

    /**
     * Called to determine whether this AdapterDelegate is the responsible for the given data element.

     * @param item     Given data element
     * *
     * @param position The position in the data source
     * *
     * @return true, if this item is responsible, otherwise false
     */
    abstract fun isForViewType(item: T, position: Int): Boolean

    /**
     * Creates the [RecyclerView.ViewHolder] for the given data source item.

     * @param parent The ViewGroup parent of the given data source
     * *
     * @return The new instantiated [RecyclerView.ViewHolder]
     */
    abstract fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    /**
     * Called to bind the [RecyclerView.ViewHolder] to the item of the datas source set.

     * @param item     Data element
     * *
     * @param position The position in the data source
     * *
     * @param holder   The [RecyclerView.ViewHolder] to bind
     */
    abstract fun onBindViewHolder(item: T, position: Int, holder: RecyclerView.ViewHolder)
}