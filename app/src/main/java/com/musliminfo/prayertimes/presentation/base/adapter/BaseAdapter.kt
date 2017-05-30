package com.musliminfo.prayertimes.presentation.base.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.musliminfo.prayertimes.presentation.base.adapter.delegate.AdapterDelegate
import com.musliminfo.prayertimes.presentation.base.adapter.delegate.AdapterDelegateManager
import java.util.*

class BaseAdapter<T> : RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private val adapterDelegateManager: AdapterDelegateManager<T>
    var items: List<T> = ArrayList()
        private set

    constructor(items: List<T>) {
        this.items = items
        adapterDelegateManager = AdapterDelegateManager()
    }

    constructor(items: List<T>, delegates: List<AdapterDelegate<T>>) {
        this.items = items
        adapterDelegateManager = AdapterDelegateManager()
        for (adapterDelegate in delegates) {
            attachDelegate(adapterDelegate)
        }
    }

    protected fun attachDelegate(adapterDelegate: AdapterDelegate<T>) {
        adapterDelegateManager.addDelegate(adapterDelegate)
    }

    protected fun clearDelegates() {
        adapterDelegateManager.clearDelegates()
    }

    override fun getItemViewType(position: Int): Int {
        return adapterDelegateManager.getItemViewType(items[position], position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return adapterDelegateManager.onCreateViewHolder(parent, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        adapterDelegateManager.onBindViewHolder(items[position], position,
                holder)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
