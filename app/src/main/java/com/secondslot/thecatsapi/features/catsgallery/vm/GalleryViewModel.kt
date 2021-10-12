package com.secondslot.thecatsapi.features.catsgallery.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.secondslot.thecatsapi.TheCatApiApplication
import com.secondslot.thecatsapi.data.repository.model.Cat
import com.secondslot.thecatsapi.domain.usecase.GetCatsUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class GalleryViewModel(private val getCatsUseCase: GetCatsUseCase) : ViewModel() {

    init {
        // For what do you use this providing?
        TheCatApiApplication.getComponent().injectGalleryFragment(this)
    }

    val cats: StateFlow<PagingData<Cat>> = Pager(PagingConfig(pageSize = 50)) {
        getCatsUseCase.execute()
    }
        .flow
        .cachedIn(viewModelScope)
        .stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())
}
