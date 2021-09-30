package com.secondslot.thecatsapi.di

import com.secondslot.seloustev.di.ApplicationScope
import com.secondslot.thecatsapi.domain.usecase.GetCatsUseCase
import com.secondslot.thecatsapi.features.catsgallery.vm.GalleryViewModel
import dagger.Component

@ApplicationScope
@Component(modules = [AppModule::class])
interface AppComponent {

    fun injectGalleryFragment(viewModel: GalleryViewModel)

    fun injectCatsUseCase(): GetCatsUseCase
}
