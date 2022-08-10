package com.dontsu.domain.repository.detail.remote

import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState

interface DigimonDetailRemoteDataSource {
    suspend fun getDigimon(id: Int): UiState<Digimon>
}
