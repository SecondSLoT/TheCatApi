package com.secondslot.thecatsapi.di

import android.content.Context
import com.secondslot.seloustev.di.ApplicationScope
import com.secondslot.thecatsapi.data.api.retrofit.TheCatApiService
import com.secondslot.thecatsapi.data.local.ImageDownloader
import dagger.Module
import dagger.Provides

@Module
class AppModule(
    private val context: Context
) {

    @ApplicationScope
    @Provides
    fun provideTheCatApiService(): TheCatApiService = TheCatApiService.create()

    // Look at the @Binds + Inject to the constructor instead of manual instantiate dependencies for this case.
//    @ApplicationScope
//    @Provides
//    fun provideCatsRepository(): CatsRepository =
//        CatsRepositoryImpl(CatsPagingSource(provideTheCatApiService()))

    @Provides
    fun provideImageDownloader(): ImageDownloader = ImageDownloader(context)
}
