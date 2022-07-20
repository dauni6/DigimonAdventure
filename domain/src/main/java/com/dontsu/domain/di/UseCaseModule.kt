package com.dontsu.domain.di

import com.dontsu.domain.usecase.list.GetDigimonListUseCase
import com.dontsu.domain.usecase.list.GetDigimonListUseCaseImpl
import com.dontsu.domain.usecase.search.GetDigimonSearchUseCase
import com.dontsu.domain.usecase.search.GetDigimonSearchUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindGetDigimonListUseCase(
        getDigimonListUseCaseImpl: GetDigimonListUseCaseImpl
    ): GetDigimonListUseCase

    @Binds
    abstract fun bindGetDigimonSearchUseCase(
        getDigimonSearchUseCaseImpl: GetDigimonSearchUseCaseImpl
    ): GetDigimonSearchUseCase

}
