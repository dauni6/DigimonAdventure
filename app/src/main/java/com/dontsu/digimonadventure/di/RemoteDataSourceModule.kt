package com.dontsu.digimonadventure.di

import com.dontsu.data.network.DigimonApi
import com.dontsu.data.repository.detail.remote.DigimonDetailRemoteDataSourceImpl
import com.dontsu.data.repository.list.remote.DigimonListRemotePagingSource
import com.dontsu.data.repository.search.remote.DigimonSearchRemoteDataSourceImpl
import com.dontsu.domain.repository.detail.remote.DigimonDetailRemoteDataSource
import com.dontsu.domain.repository.search.remote.DigimonSearchRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    @Provides
    @Singleton
    fun provideDigimonSearchRemoteDataSource(
        digimonApi: DigimonApi,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): DigimonSearchRemoteDataSource {
        return DigimonSearchRemoteDataSourceImpl(api = digimonApi, ioDispatcher = ioDispatcher)
    }

    @Provides
    @Singleton
    fun provideDigimonDetailRemoteDataSource(
        digimonApi: DigimonApi,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): DigimonDetailRemoteDataSource {
        return DigimonDetailRemoteDataSourceImpl(
            api = digimonApi,
            ioDispatcher = ioDispatcher
        )
    }

    @Provides
    fun provideDigimonListRemotePagingSource(
        digimonApi: DigimonApi,
        @IoDispatcher ioDispatcher: CoroutineDispatcher
    ): DigimonListRemotePagingSource {
        return DigimonListRemotePagingSource(
            api = digimonApi,
            ioDispatcher = ioDispatcher
        )
    }

}
