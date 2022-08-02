package com.dontsu.domain.usecase.detail

import com.dontsu.domain.model.Favorite
import com.dontsu.domain.repository.detail.DigimonDetailRepository
import javax.inject.Inject

class AddDigimonDetailFavoriteUseCaseImpl @Inject constructor(
    private val repository: DigimonDetailRepository
): AddDigimonDetailFavoriteUseCase {
    override suspend fun invoke(favorite: Favorite) {
        repository.addFavorite(favorite = favorite)
    }
}
