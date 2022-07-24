package com.dontsu.domain.usecase.detail

import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.detail.DigimonDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDigimonDetailUseCaseImpl @Inject constructor(
    private val repository: DigimonDetailRepository
): GetDigimonDetailUseCase {
    override fun invoke(id: Int): Flow<UiState<Digimon>> {
        return repository.getDigimon(id = id)
    }
}
