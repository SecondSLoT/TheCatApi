package com.secondslot.thecatsapi.features.catdetails.vm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CatDetailsViewModelFactory(private val app: Application) :
    ViewModelProvider.AndroidViewModelFactory(app) {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CatDetailsViewModel::class.java)) {
            return CatDetailsViewModel(app) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
