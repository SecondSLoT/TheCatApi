package com.secondslot.thecatsapi.data.repository.di

import com.secondslot.thecatsapi.data.repository.CatsRepositoryImpl
import com.secondslot.thecatsapi.domain.CatsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    // Look at the @Binds + Inject to the constructor instead of manual instantiate dependencies for this case.
    // Done
    @Binds
    abstract fun provideCatsRepository(repository: CatsRepositoryImpl): CatsRepository
}
