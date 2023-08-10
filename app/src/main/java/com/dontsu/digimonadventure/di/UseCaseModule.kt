package com.dontsu.digimonadventure.di

import com.dontsu.domain.usecase.detail.*
import com.dontsu.domain.usecase.list.GetDigimonListUseCase
import com.dontsu.domain.usecase.list.GetDigimonListUseCaseImpl
import com.dontsu.domain.usecase.list.GetDigimonPagingListUseCase
import com.dontsu.domain.usecase.list.GetDigimonPagingListUseCaseImpl
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
    abstract fun bindGetDigimonPagingListUseCase(
        getDigimonPagingListUseCaseImpl: GetDigimonPagingListUseCaseImpl
    ): GetDigimonPagingListUseCase

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

    @Binds
    @ViewModelScoped
    abstract fun bindAddDigimonDetailFavoriteUseCase(
        addDigimonDetailFavoriteUseCaseImpl: AddDigimonDetailFavoriteUseCaseImpl
    ): AddDigimonDetailFavoriteUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetDigimonDetailFavoriteUseCase(
       getDigimonDetailFavoriteUseCaseImpl: GetDigimonDetailFavoriteUseCaseImpl
    ): GetDigimonDetailFavoriteUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindDeleteDigimonDeailFavoriteUseCase(
        deleteDigimonDetailFavoriteUseCaseImpl: DeleteDigimonDetailFavoriteUseCaseImpl
    ): DeleteDigimonDetailFavoriteUseCase

}
