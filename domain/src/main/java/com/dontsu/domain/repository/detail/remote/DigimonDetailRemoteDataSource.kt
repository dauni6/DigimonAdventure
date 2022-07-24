package com.dontsu.domain.repository.detail.remote

import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState
import kotlinx.coroutines.flow.Flow

interface DigimonDetailRemoteDataSource {
    fun getDigimon(id: Int): Flow<UiState<Digimon>>
}
