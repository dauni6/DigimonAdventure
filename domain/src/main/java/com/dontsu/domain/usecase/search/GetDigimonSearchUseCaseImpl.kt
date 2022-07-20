package com.dontsu.domain.usecase.search

import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.search.DigimonSearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDigimonSearchUseCaseImpl @Inject constructor(
    private val repository: DigimonSearchRepository
): GetDigimonSearchUseCase {
    override suspend fun invoke(id: Int): Flow<UiState<Digimon>> {
        return repository.searchDigimon(id = id)
    }
}
