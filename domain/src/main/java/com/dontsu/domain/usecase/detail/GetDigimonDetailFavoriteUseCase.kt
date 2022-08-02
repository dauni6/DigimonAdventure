package com.dontsu.domain.usecase.detail

import com.dontsu.domain.model.Favorite
import com.dontsu.domain.model.UiState
import kotlinx.coroutines.flow.Flow

interface GetDigimonDetailFavoriteUseCase {
    operator fun invoke(id: Int): Flow<UiState<Favorite>>
}
