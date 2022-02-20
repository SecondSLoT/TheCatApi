package com.secondslot.thecatsapi.features.catsgallery.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.secondslot.seloustev.extentions.loadImage
import com.secondslot.thecatsapi.databinding.ItemCatBinding
import com.secondslot.thecatsapi.domain.model.Cat
import com.secondslot.thecatsapi.features.catsgallery.ui.CatListener

class CatAdapter(
    private val listener: CatListener
) : PagingDataAdapter<Cat, CatViewHolder>(CatComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemCatBinding.inflate(layoutInflater, parent, false)
        val holder = CatViewHolder(binding)
        holder.itemView.setOnClickListener {
            getItem(holder.bindingAdapterPosition)?.let { cat -> listener.onCatSelected(cat) }
        }
        return holder
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        // This position isn't final. Better to use holder.bindingAdapterPosition.
        // Fixed
        getItem(holder.bindingAdapterPosition)?.let { cat ->
            holder.binding.catImageView.loadImage(cat.url)
        }
    }

    class CatComparator : DiffUtil.ItemCallback<Cat>() {

        override fun areItemsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Cat, newItem: Cat): Boolean {
            return oldItem.id == newItem.id
        }

        override fun getChangePayload(oldItem: Cat, newItem: Cat) = Any()
    }
}

class CatViewHolder(internal val binding: ItemCatBinding) :
    RecyclerView.ViewHolder(binding.root)
