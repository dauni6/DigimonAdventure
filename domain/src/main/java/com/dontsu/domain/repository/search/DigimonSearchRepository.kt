package com.dontsu.domain.repository.search

import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState
import kotlinx.coroutines.flow.Flow

interface DigimonSearchRepository {
    fun searchDigimon(id: Int): Flow<UiState<Digimon>>
}
