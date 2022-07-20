package com.dontsu.data.repository.search

import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.search.DigimonSearchRepository
import com.dontsu.domain.repository.search.local.DigimonSearchLocalDataSource
import com.dontsu.domain.repository.search.remote.DigimonSearchRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DigimonSearchRepositoryImpl @Inject constructor(
    private val remoteDataSource: DigimonSearchRemoteDataSource,
    private val localDataSource: DigimonSearchLocalDataSource
): DigimonSearchRepository {

    override fun searchDigimon(id: Int): Flow<UiState<Digimon>> {
        TODO("Not yet implemented")
    }
}
