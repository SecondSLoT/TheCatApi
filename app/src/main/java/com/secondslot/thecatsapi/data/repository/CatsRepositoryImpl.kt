package com.secondslot.thecatsapi.data.repository

import androidx.paging.PagingSource
import com.secondslot.seloustev.di.ApplicationScope
import com.secondslot.thecatsapi.data.api.model.CatsPagingSource
import com.secondslot.thecatsapi.domain.model.Cat
import com.secondslot.thecatsapi.domain.CatsRepository
import javax.inject.Inject

@ApplicationScope
class CatsRepositoryImpl @Inject constructor(
    private val pagingSource: CatsPagingSource
) : CatsRepository {

    override fun getPhotos(): PagingSource<Int, Cat> {
        return pagingSource
    }
}
