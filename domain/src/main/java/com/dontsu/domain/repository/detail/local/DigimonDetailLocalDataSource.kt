package com.dontsu.domain.repository.detail.local

import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState
import kotlinx.coroutines.flow.Flow

interface DigimonDetailLocalDataSource {
    suspend fun getDigimon(id: Int): UiState<Digimon>

    suspend fun insertDigimon(digimon: Digimon)
}
