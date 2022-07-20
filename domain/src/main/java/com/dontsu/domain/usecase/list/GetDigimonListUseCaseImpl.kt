package com.dontsu.domain.usecase.list

import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.list.DigimonListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDigimonListUseCaseImpl @Inject constructor(
    private val repository: DigimonListRepository
): GetDigimonListUseCase {
    override suspend fun invoke(pageSize: Int): Flow<UiState<DigimonList>> {
        return repository.getDigimonList(pageSize = pageSize)
    }
}
