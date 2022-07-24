package com.dontsu.domain.usecase.search

import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.search.DigimonSearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDigimonSearchUseCaseImpl @Inject constructor(
    private val repository: DigimonSearchRepository
): GetDigimonSearchUseCase {
    override fun invoke(name: String): Flow<UiState<DigimonList>> {
        return repository.searchDigimon(name = name)
    }
}
