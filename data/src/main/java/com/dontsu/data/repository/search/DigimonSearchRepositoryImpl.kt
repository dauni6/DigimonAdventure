package com.dontsu.data.repository.search

import com.dontsu.domain.model.DigimonList
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

    override fun searchDigimon(name: String): Flow<UiState<DigimonList>> {
//        val digimonFromDB = localDataSource.getDigimon()
//        if (digimonFromDB.isNotEmpty) {
//            return digimonListFromDB
//        }
       return remoteDataSource.searchDigimon(name = name)
    }
}
