package com.secondslot.thecatsapi.features.catdetails.vm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.secondslot.thecatsapi.TheCatApiApplication

class CatDetailsViewModelFactory(private val app: Application) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CatDetailsViewModel::class.java)) {
            return CatDetailsViewModel(
                TheCatApiApplication.getComponent().getImageDownloader()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
