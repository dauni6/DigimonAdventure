package com.dontsu.domain.usecase.detail

import com.dontsu.domain.model.Favorite

interface AddDigimonDetailFavoriteUseCase {
    suspend operator fun invoke(favorite: Favorite)
}
