package com.secondslot.thecatsapi.di

import com.secondslot.seloustev.di.ApplicationScope
import com.secondslot.thecatsapi.data.api.model.CatsPagingSource
import com.secondslot.thecatsapi.data.api.retrofit.TheCatApiService
import com.secondslot.thecatsapi.data.repository.CatsRepositoryImpl
import com.secondslot.thecatsapi.domain.CatsRepository
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @ApplicationScope
    @Provides
    fun provideTheCatApiService(): TheCatApiService = TheCatApiService.create()

    @ApplicationScope
    @Provides
    fun provideCatsRepository(): CatsRepository =
        CatsRepositoryImpl(CatsPagingSource(provideTheCatApiService()))
}
