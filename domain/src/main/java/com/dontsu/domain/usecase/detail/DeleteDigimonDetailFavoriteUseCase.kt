package com.dontsu.domain.usecase.detail

import com.dontsu.domain.model.Favorite

interface DeleteDigimonDetailFavoriteUseCase {
    suspend operator fun invoke(favorite: Favorite)
}
