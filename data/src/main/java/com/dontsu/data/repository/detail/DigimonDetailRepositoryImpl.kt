package com.dontsu.data.repository.detail

import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState
import com.dontsu.domain.model.successOrNull
import com.dontsu.domain.repository.detail.DigimonDetailRepository
import com.dontsu.domain.repository.detail.local.DigimonDetailLocalDataSource
import com.dontsu.domain.repository.detail.remote.DigimonDetailRemoteDataSource
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class DigimonDetailRepositoryImpl @Inject constructor(
    private val remoteDataSource: DigimonDetailRemoteDataSource,
    private val localDataSource: DigimonDetailLocalDataSource,
): DigimonDetailRepository {

    override fun getDigimon(id: Int): Flow<UiState<Digimon>> = flow {
        val digimonFromDB = localDataSource.getDigimon(id = id)
        digimonFromDB.collect { resultFromDB ->
            if (resultFromDB is UiState.Success) {
                return@collect emit(resultFromDB) // return@collect???
            } else {
                remoteDataSource.getDigimon(id = id).collect { resultFromRemote ->
                    if (resultFromRemote is UiState.Success) {
                        resultFromRemote.successOrNull()?.let {
                            localDataSource.insertDigimon(it)
                        }
                    }
                    emit(resultFromRemote)
                }
            }
        }
    }
}
