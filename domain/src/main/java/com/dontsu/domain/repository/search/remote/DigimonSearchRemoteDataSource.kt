package com.dontsu.domain.repository.search.remote

import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import kotlinx.coroutines.flow.Flow

interface DigimonSearchRemoteDataSource {
    fun searchDigimon(name: String): Flow<UiState<DigimonList>>
}
