package com.dontsu.domain.repository.detail

import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState
import kotlinx.coroutines.flow.Flow

interface DigimonDetailRepository {

    fun getDigimon(id: Int): Flow<UiState<Digimon>>

}