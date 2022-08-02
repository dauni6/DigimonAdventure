package com.dontsu.domain.repository.detail.local

import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.Favorite
import com.dontsu.domain.model.UiState
import kotlinx.coroutines.flow.Flow

interface DigimonDetailLocalDataSource {
    fun getDigimon(id: Int): Flow<UiState<Digimon>>

    suspend fun insertDigimon(digimon: Digimon)

    suspend fun addFavorite(favorite: Favorite)

    fun getFavorite(id: Int): Flow<UiState<Favorite>>

    suspend fun deleteFavorite(favorite: Favorite)
}
