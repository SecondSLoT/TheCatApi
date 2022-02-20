package com.secondslot.thecatsapi.domain

import androidx.paging.PagingSource
import com.secondslot.thecatsapi.domain.model.Cat

interface CatsRepository {

    fun getPhotos(): PagingSource<Int, Cat>
}
