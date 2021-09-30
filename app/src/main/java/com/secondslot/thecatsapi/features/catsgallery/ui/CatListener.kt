package com.secondslot.thecatsapi.features.catsgallery.ui

import com.secondslot.thecatsapi.data.repository.model.Cat

interface CatListener {
    fun onCatSelected(cat: Cat)
}
