package com.dontsu.digimonadventure.di

import com.dontsu.data.network.DigimonApi
import com.dontsu.data.repository.detail.DigimonDetailRepositoryImpl
import com.dontsu.data.repository.list.DigimonListRepositoryImpl
import com.dontsu.data.repository.search.DigimonSearchRepositoryImpl
import com.dontsu.domain.repository.detail.DigimonDetailRepository
import com.dontsu.domain.repository.detail.local.DigimonDetailLocalDataSource
import com.dontsu.domain.repository.detail.remote.DigimonDetailRemoteDataSource
import com.dontsu.domain.repository.list.DigimonListRepository
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
    fun provideDigimonListRepository(
        api: DigimonApi,
    ): DigimonListRepository {
        return DigimonListRepositoryImpl(
            api = api,
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

    @Provides
    @Singleton
    fun provideDigimonDetailRepository(
        remoteDataSource: DigimonDetailRemoteDataSource,
        localDataSource: DigimonDetailLocalDataSource
    ): DigimonDetailRepository {
        return DigimonDetailRepositoryImpl(
            remoteDataSource = remoteDataSource,
            localDataSource = localDataSource
        )
    }

}
