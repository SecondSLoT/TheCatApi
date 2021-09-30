package com.secondslot.thecatsapi.features.catsgallery.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.secondslot.thecatsapi.data.repository.model.Cat
import com.secondslot.thecatsapi.features.catsgallery.ui.CatListener
import com.secondslot.thecatsapi.features.catsgallery.ui.CatViewHolder

class CatAdapter(
    private val listener: CatListener
) : PagingDataAdapter<Cat, CatViewHolder>(CAT_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder.create(parent, listener)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {
        private val CAT_COMPARATOR = object : DiffUtil.ItemCallback<Cat>() {

            override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
                return oldItem.id == newItem.id
            }

            override fun getChangePayload(oldItem: Cat, newItem: Cat) = Any()
        }
    }
}
