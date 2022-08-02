package com.dontsu.domain.usecase.detail

import com.dontsu.domain.model.Favorite
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.detail.DigimonDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDigimonDetailFavoriteUseCaseImpl @Inject constructor(
    private val repository: DigimonDetailRepository
): GetDigimonDetailFavoriteUseCase {
    override fun invoke(id: Int): Flow<UiState<Favorite>> {
        return repository.getFavorite(id = id)
    }
}
