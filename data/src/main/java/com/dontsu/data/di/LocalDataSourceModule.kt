package com.dontsu.data.di

import com.dontsu.data.repository.detail.local.DigimonDetailLocalDataSourceImpl
import com.dontsu.data.repository.list.local.DigimonListLocalDataSourceImpl
import com.dontsu.data.repository.search.local.DigimonSearchLocalDataSourceImpl
import com.dontsu.domain.repository.detail.local.DigimonDetailLocalDataSource
import com.dontsu.domain.repository.list.local.DigimonListLocalDataSource
import com.dontsu.domain.repository.search.local.DigimonSearchLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {

    @Provides
    @Singleton
    fun provideDigimonListLocalDataSource(): DigimonListLocalDataSource {
        return DigimonListLocalDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideDigimonSearchLocalDataSource(): DigimonSearchLocalDataSource {
        return DigimonSearchLocalDataSourceImpl()
    }

    @Provides
    @Singleton
    fun provideDigimonDetailLocalDataSource(): DigimonDetailLocalDataSource {
        return DigimonDetailLocalDataSourceImpl()
    }

}
