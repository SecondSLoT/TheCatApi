package com.secondslot.thecatsapi.features.catsgallery.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.secondslot.thecatsapi.domain.usecase.GetCatsUseCase

class GalleryViewModelFactory(private val getCatsUseCase: GetCatsUseCase) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GalleryViewModel::class.java)) {
            return GalleryViewModel(getCatsUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
