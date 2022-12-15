package com.suncorp.data.di

import com.suncorp.data.repository.RepositoryImpl
import com.suncorp.domain.repository.RepositoryInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(repository: RepositoryImpl): RepositoryInterface {
        return repository
    }
}
