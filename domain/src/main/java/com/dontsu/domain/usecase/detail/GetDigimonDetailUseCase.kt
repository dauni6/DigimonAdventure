package com.dontsu.domain.usecase.detail

import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState
import kotlinx.coroutines.flow.Flow

interface GetDigimonDetailUseCase {
    suspend operator fun invoke(id: Int): UiState<Digimon>
}
