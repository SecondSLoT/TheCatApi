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

//import javax.inject.Inject

private const val TAG = "GalleryViewModel"

class GalleryViewModel(private val getCatsUseCase: GetCatsUseCase) : ViewModel() {

    val requestListener = object : RequestListener<Drawable> {

        override fun onLoadFailed(
            e: GlideException?,
            model: Any?,
            target: Target<Drawable>?,
            isFirstResource: Boolean
        ): Boolean {

            Log.d(TAG, "onLoadFailed()")

            return false
        }

        override fun onResourceReady(
            resource: Drawable?,
            model: Any?,
            target: Target<Drawable>?,
            dataSource: DataSource?,
            isFirstResource: Boolean
        ): Boolean {

            Log.d(TAG, "onResourceReady()")

            return false
        }
    }

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
