package com.dontsu.data.repository.list

import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.list.DigimonListRepository
import com.dontsu.domain.repository.list.local.DigimonListLocalDataSource
import com.dontsu.domain.repository.list.remote.DigimonListRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DigimonListRepositoryImpl @Inject constructor(
    private val remoteDataSource: DigimonListRemoteDataSource,
    private val localDataSource: DigimonListLocalDataSource
): DigimonListRepository {

    override suspend fun getDigimonList(pageSize: Int): Flow<UiState<DigimonList>> {
        // todo : check local data before fetching remote data.
//        val digimonListFromDB = localDataSource.getDigimonList()
//        if (digimonListFromDB.isNotEmpty) {
//            emit(digimonListFromDB)
//            return@flow
//        }

        return remoteDataSource.getDigimonList(pageSize = pageSize)
    }

}
