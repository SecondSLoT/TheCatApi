package com.secondslot.thecatsapi.features.catsgallery.ui

import com.secondslot.thecatsapi.domain.model.Cat

interface CatListener {
    fun onCatSelected(cat: Cat)
}
