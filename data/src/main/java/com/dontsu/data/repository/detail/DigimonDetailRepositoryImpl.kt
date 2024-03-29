package com.dontsu.data.repository.detail

import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.Favorite
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.detail.DigimonDetailRepository
import com.dontsu.domain.repository.detail.local.DigimonDetailLocalDataSource
import com.dontsu.domain.repository.detail.remote.DigimonDetailRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DigimonDetailRepositoryImpl @Inject constructor(
    private val remoteDataSource: DigimonDetailRemoteDataSource,
    private val localDataSource: DigimonDetailLocalDataSource
): DigimonDetailRepository {

    override suspend fun getDigimon(id: Int): Digimon {
        return try {
            localDataSource.getDigimon(id = id)
        } catch (e: Exception) {
            val resultFromRemote = remoteDataSource.getDigimon(id = id)
            localDataSource.insertDigimon(resultFromRemote)
            resultFromRemote
        }
    }

    override suspend fun addFavorite(favorite: Favorite) {
        localDataSource.addFavorite(favorite = favorite)
    }

    override fun getFavorite(id: Int): Flow<UiState<Favorite>> {
        return localDataSource.getFavorite(id = id)
    }

    override suspend fun deleteFavorite(favorite: Favorite) {
        localDataSource.deleteFavorite(favorite = favorite)
    }
}
