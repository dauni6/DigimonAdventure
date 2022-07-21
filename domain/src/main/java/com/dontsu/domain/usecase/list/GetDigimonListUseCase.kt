package com.dontsu.domain.usecase.list

import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import kotlinx.coroutines.flow.Flow

interface GetDigimonListUseCase {
    operator fun invoke(pageSize: Int): Flow<UiState<DigimonList>>
}
