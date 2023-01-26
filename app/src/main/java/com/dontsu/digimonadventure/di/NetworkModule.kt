package com.dontsu.digimonadventure.di

import com.dontsu.data.network.DigimonApi
import com.dontsu.data.network.DigimonLoggingInterceptor
import com.dontsu.data.util.Url.DIGIMON_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(DIGIMON_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpclient(interceptor: DigimonLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(5, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideDigimonLoggingInterceptor(): DigimonLoggingInterceptor {
        return DigimonLoggingInterceptor()
    }

    @Provides
    @Singleton
    fun provideDigimonApi(retrofit: Retrofit): DigimonApi {
        return retrofit.create(DigimonApi::class.java)
    }

}
