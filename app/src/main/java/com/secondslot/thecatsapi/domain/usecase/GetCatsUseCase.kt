package com.secondslot.thecatsapi.domain.usecase

import androidx.paging.PagingSource
import com.secondslot.thecatsapi.domain.model.Cat
import com.secondslot.thecatsapi.domain.CatsRepository
import javax.inject.Inject

class GetCatsUseCase @Inject constructor(private val repository: CatsRepository) {

    fun execute(): PagingSource<Int, Cat> {
        return repository.getPhotos()
    }
}
