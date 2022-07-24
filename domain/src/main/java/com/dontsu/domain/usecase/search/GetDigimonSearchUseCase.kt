package com.dontsu.domain.usecase.search

import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import kotlinx.coroutines.flow.Flow

interface GetDigimonSearchUseCase {
    suspend operator fun invoke(name: String): Flow<UiState<DigimonList>>
}
