package com.dontsu.domain.usecase.detail

import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState
import kotlinx.coroutines.flow.Flow

interface GetDigimonDetailUseCase {
    operator fun invoke(id: Int): Flow<UiState<Digimon>>
}
