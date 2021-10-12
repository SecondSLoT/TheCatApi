package com.secondslot.thecatsapi.features.catsgallery.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.secondslot.seloustev.extentions.loadImage
import com.secondslot.thecatsapi.data.repository.model.Cat
import com.secondslot.thecatsapi.databinding.ItemCatBinding

// It can be more simple and without nullable Cat. Let's discuss that.
class CatViewHolder(
    private val binding: ItemCatBinding,
    private val listener: CatListener
) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    private var cat: Cat? = null

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(cat: Cat) {

        this.cat = cat

        binding.catImageView.loadImage(cat.url)
    }

    override fun onClick(p0: View?) {
        cat?.let { listener.onCatSelected(it) }
    }

    companion object {
        fun create(parent: ViewGroup, listener: CatListener): CatViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemCatBinding.inflate(layoutInflater, parent, false)
            return CatViewHolder(binding, listener)
        }
    }
}
