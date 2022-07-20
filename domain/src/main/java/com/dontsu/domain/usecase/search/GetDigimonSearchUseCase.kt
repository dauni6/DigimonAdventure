package com.dontsu.domain.usecase.search

import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState
import kotlinx.coroutines.flow.Flow

interface GetDigimonSearchUseCase {
    suspend operator fun invoke(id: Int): Flow<UiState<Digimon>>
}
