package com.secondslot.thecatsapi.features.catdetails.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.secondslot.thecatsapi.core.liveDataEventWrapper.LiveDataEvent
import com.secondslot.thecatsapi.data.local.ImageDownloader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CatDetailsViewModel(
    private val imageDownloader: ImageDownloader
) : ViewModel() {

    private var _imageSavedLiveData = MutableLiveData<LiveDataEvent<Boolean>>()
    val imageSavedLiveData get() = _imageSavedLiveData as LiveData<LiveDataEvent<Boolean>>

    fun downloadImage(url: String) {

        var saveResult = false

        viewModelScope.launch(Dispatchers.IO) {
            saveResult = imageDownloader.saveMediaToStorage(url)
        }

        _imageSavedLiveData.value = LiveDataEvent(saveResult)
    }
}
