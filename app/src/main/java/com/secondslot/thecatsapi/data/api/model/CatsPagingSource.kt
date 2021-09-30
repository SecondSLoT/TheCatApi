package com.secondslot.thecatsapi.data.api.model

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.secondslot.thecatsapi.data.api.retrofit.TheCatApiService
import com.secondslot.thecatsapi.data.repository.model.Cat
import retrofit2.HttpException
import javax.inject.Inject

private const val TAG = "CatsPagingSource"

class CatsPagingSource @Inject constructor(
    private val service: TheCatApiService
) : PagingSource<Int, Cat>() {

    override fun getRefreshKey(state: PagingState<Int, Cat>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Cat> {

        val page: Int = params.key ?: INITIAL_PAGE_NUMBER
        val pageSize: Int = params.loadSize.coerceAtMost(TheCatApiService.MAX_PAGE_SIZE)

        try {
            val response = service.getPhotos(pageSize, page)

            return if (response.isSuccessful) {
                val cats = checkNotNull(response.body()).map { it.toItem() }
                val nextKey = if (cats.size < pageSize) null else page + 1
                val prevKey = if (page == 1) null else page - 1
                LoadResult.Page(cats, prevKey, nextKey)
            } else {
                LoadResult.Error(HttpException(response))
            }

        } catch (e: Exception) {
            Log.e(TAG, "Error downloading photos from server")
            return LoadResult.Error(e)
        }
    }

    companion object {
        private const val INITIAL_PAGE_NUMBER = 1
    }
}
