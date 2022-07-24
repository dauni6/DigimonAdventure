package com.dontsu.domain.repository.search

import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import kotlinx.coroutines.flow.Flow

interface DigimonSearchRepository {
    fun searchDigimon(name: String): Flow<UiState<DigimonList>>
}
