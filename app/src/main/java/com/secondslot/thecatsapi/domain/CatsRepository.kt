package com.secondslot.thecatsapi.domain

import androidx.paging.PagingSource
import com.secondslot.thecatsapi.data.repository.model.Cat

interface CatsRepository {

    fun getPhotos(): PagingSource<Int, Cat>
}
