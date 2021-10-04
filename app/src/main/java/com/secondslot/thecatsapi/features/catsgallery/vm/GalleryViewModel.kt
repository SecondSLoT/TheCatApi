package com.secondslot.thecatsapi.features.catsgallery.vm

import android.graphics.drawable.Drawable
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.secondslot.thecatsapi.TheCatApiApplication
import com.secondslot.thecatsapi.data.repository.model.Cat
import com.secondslot.thecatsapi.domain.usecase.GetCatsUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

private const val TAG = "GalleryViewModel"

class GalleryViewModel(private val getCatsUseCase: GetCatsUseCase) : ViewModel() {

    init {
        TheCatApiApplication.getComponent().injectGalleryFragment(this)
    }

    val cats: StateFlow<PagingData<Cat>> = Pager(PagingConfig(pageSize = 50)) {
        getCatsUseCase.execute()
    }
        .flow
        .cachedIn(viewModelScope)
        .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())
}
