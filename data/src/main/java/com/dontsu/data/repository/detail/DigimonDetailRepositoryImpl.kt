package com.dontsu.data.repository.detail

import com.dontsu.domain.model.Digimon
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
    override fun getDigimon(id: Int): Flow<UiState<Digimon>> {
        // todo : check local data before fetching remote data.
//        val digimonFromDB = localDataSource.getDigimon()
//        if (digimonFromDB.isNotEmpty) {
//            return digimonFromDB
//        }
        return remoteDataSource.getDigimon(id = id)
    }

}
