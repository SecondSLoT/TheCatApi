package com.secondslot.thecatsapi.data.api.retrofit

import com.secondslot.thecatsapi.data.api.model.CatRemote
import com.secondslot.thecatsapi.data.api.okhttp.CatsRequestInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface TheCatApiService {

    @GET("search")
    suspend fun getPhotos(
        @Query("limit") limit: Int,
        @Query("page") page: Int,
        @Query("order") order: String = "desc"
    ): Response<List<CatRemote>>

    companion object {
        private const val BASE_URL = "https://api.thecatapi.com/v1/images/"
        const val MAX_PAGE_SIZE = 50

        fun create(): TheCatApiService {

            val logger = HttpLoggingInterceptor()
            logger.level = Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(CatsRequestInterceptor())
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(TheCatApiService::class.java)
        }
    }
}
