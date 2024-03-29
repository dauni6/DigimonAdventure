package com.dontsu.domain.repository.detail

import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.Favorite
import com.dontsu.domain.model.UiState
import kotlinx.coroutines.flow.Flow

interface DigimonDetailRepository {

    suspend fun getDigimon(id: Int): Digimon

    suspend fun addFavorite(favorite: Favorite)

    fun getFavorite(id: Int): Flow<UiState<Favorite>>

    suspend fun deleteFavorite(favorite: Favorite)

}
