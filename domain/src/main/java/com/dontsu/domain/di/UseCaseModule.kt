package com.dontsu.domain.di

import com.dontsu.domain.usecase.detail.GetDigimonDetailUseCase
import com.dontsu.domain.usecase.detail.GetDigimonDetailUseCaseImpl
import com.dontsu.domain.usecase.list.GetDigimonListUseCase
import com.dontsu.domain.usecase.list.GetDigimonListUseCaseImpl
import com.dontsu.domain.usecase.search.GetDigimonSearchUseCase
import com.dontsu.domain.usecase.search.GetDigimonSearchUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGetDigimonListUseCase(
        getDigimonListUseCaseImpl: GetDigimonListUseCaseImpl
    ): GetDigimonListUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetDigimonSearchUseCase(
        getDigimonSearchUseCaseImpl: GetDigimonSearchUseCaseImpl
    ): GetDigimonSearchUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetDigimonDetailUseCase(
        getDigimonDetailUseCaseImpl: GetDigimonDetailUseCaseImpl
    ): GetDigimonDetailUseCase

}
