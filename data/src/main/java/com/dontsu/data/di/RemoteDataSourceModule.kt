package com.dontsu.data.di

import com.dontsu.data.network.DigimonApi
import com.dontsu.data.repository.list.remote.DigimonListRemoteDataSourceImpl
import com.dontsu.data.repository.search.remote.DigimonSearchRemoteDataSourceImpl
import com.dontsu.domain.repository.list.remote.DigimonListRemoteDataSource
import com.dontsu.domain.repository.search.remote.DigimonSearchRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    @Provides
    @Singleton
    fun provideDigimonListRemoteDataSource(digimonApi: DigimonApi): DigimonListRemoteDataSource {
        return DigimonListRemoteDataSourceImpl(api = digimonApi)
    }

    @Provides
    @Singleton
    fun provideDigimonSearchRemoteDataSource(digimonApi: DigimonApi): DigimonSearchRemoteDataSource {
        return DigimonSearchRemoteDataSourceImpl(api = digimonApi)
    }

}
