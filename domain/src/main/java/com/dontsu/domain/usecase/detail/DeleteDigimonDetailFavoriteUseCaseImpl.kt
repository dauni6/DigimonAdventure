package com.dontsu.domain.usecase.detail

import com.dontsu.domain.model.Favorite
import com.dontsu.domain.repository.detail.DigimonDetailRepository
import javax.inject.Inject

class DeleteDigimonDetailFavoriteUseCaseImpl @Inject constructor(
    private val repository: DigimonDetailRepository
): DeleteDigimonDetailFavoriteUseCase {
    override suspend fun invoke(favorite: Favorite) {
        repository.deleteFavorite(favorite = favorite)
    }
}