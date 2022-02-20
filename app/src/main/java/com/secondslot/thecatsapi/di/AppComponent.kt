package com.secondslot.thecatsapi.di

import com.secondslot.seloustev.di.ApplicationScope
import com.secondslot.thecatsapi.data.repository.di.RepositoryModule
import com.secondslot.thecatsapi.data.local.ImageDownloader
import com.secondslot.thecatsapi.domain.usecase.GetCatsUseCase
import com.secondslot.thecatsapi.features.catsgallery.vm.GalleryViewModel
import dagger.Component

@ApplicationScope
@Component(modules = [AppModule::class, RepositoryModule::class])
interface AppComponent {

    fun injectGalleryFragment(viewModel: GalleryViewModel)

    fun injectCatsUseCase(): GetCatsUseCase

    fun getImageDownloader(): ImageDownloader
}
