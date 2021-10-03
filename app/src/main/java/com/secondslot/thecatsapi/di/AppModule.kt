package com.secondslot.thecatsapi.di

import android.content.Context
import com.secondslot.seloustev.di.ApplicationScope
import com.secondslot.thecatsapi.data.api.model.CatsPagingSource
import com.secondslot.thecatsapi.data.api.retrofit.TheCatApiService
import com.secondslot.thecatsapi.data.repository.CatsRepositoryImpl
import com.secondslot.thecatsapi.domain.CatsRepository
import com.secondslot.thecatsapi.domain.ImageDownloader
import dagger.Module
import dagger.Provides

@Module
class AppModule(
    private val context: Context
) {

    @ApplicationScope
    @Provides
    fun provideTheCatApiService(): TheCatApiService = TheCatApiService.create()

    @ApplicationScope
    @Provides
    fun provideCatsRepository(): CatsRepository =
        CatsRepositoryImpl(CatsPagingSource(provideTheCatApiService()))

    @Provides
    fun provideImageDownloader(): ImageDownloader = ImageDownloader(context)
}
