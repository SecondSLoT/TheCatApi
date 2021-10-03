package com.secondslot.thecatsapi.domain.usecase

import androidx.paging.PagingSource
import com.secondslot.thecatsapi.data.repository.model.Cat
import com.secondslot.thecatsapi.domain.CatsRepository
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetCatsUseCaseTest {

    lateinit var useCase: GetCatsUseCase

    @Mock
    lateinit var mockCatsRepository: CatsRepository

    @Mock
    lateinit var mockPagingSource: PagingSource<Int, Cat>

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCase = GetCatsUseCase(mockCatsRepository)
        whenever(mockCatsRepository.getPhotos()).thenReturn(mockPagingSource)
    }

    @Test
    fun execute() {
        val result = useCase.execute()
        assertThat(result, instanceOf(PagingSource::class.java))
    }
}
