package com.dontsu.data.di

import com.dontsu.data.repository.list.DigimonListRepositoryImpl
import com.dontsu.data.repository.search.DigimonSearchRepositoryImpl
import com.dontsu.domain.repository.list.DigimonListRepository
import com.dontsu.domain.repository.list.local.DigimonListLocalDataSource
import com.dontsu.domain.repository.list.remote.DigimonListRemoteDataSource
import com.dontsu.domain.repository.search.DigimonSearchRepository
import com.dontsu.domain.repository.search.local.DigimonSearchLocalDataSource
import com.dontsu.domain.repository.search.remote.DigimonSearchRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDigimonListRepository(
        remoteDataSource: DigimonListRemoteDataSource,
        localDataSource: DigimonListLocalDataSource
    ): DigimonListRepository {
        return DigimonListRepositoryImpl(
            remoteDataSource = remoteDataSource,
            localDataSource = localDataSource
        )
    }

    @Provides
    @Singleton
    fun provideDigimonSearchRepository(
        remoteDataSource: DigimonSearchRemoteDataSource,
        localDataSource: DigimonSearchLocalDataSource
    ): DigimonSearchRepository {
        return DigimonSearchRepositoryImpl(
            remoteDataSource = remoteDataSource,
            localDataSource = localDataSource
        )
    }

}
