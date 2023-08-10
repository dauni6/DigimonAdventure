package com.dontsu.data.repository.list

import androidx.paging.PagingSource
import com.dontsu.data.repository.list.remote.DigimonListRemotePagingSource
import com.dontsu.domain.model.Content
import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.list.DigimonListRepository
import com.dontsu.domain.repository.list.local.DigimonListLocalDataSource
import com.dontsu.domain.repository.list.remote.DigimonListRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DigimonListRepositoryImpl @Inject constructor(
    private val remoteDataSource: DigimonListRemoteDataSource,
    private val localDataSource: DigimonListLocalDataSource, // This will be deleted soon.
    private val remotePagingSource: DigimonListRemotePagingSource
): DigimonListRepository {

    override fun getDigimonList(pageSize: Int): Flow<UiState<DigimonList>> {
        // todo : check local data before fetching remote data.
//        val digimonListFromDB = localDataSource.getDigimonList()
//        if (digimonListFromDB.isNotEmpty) {
//            return digimonListFromDB
//        }
        return remoteDataSource.getDigimonList(pageSize = pageSize)
    }

    override fun getDigimonList(): PagingSource<Int, Content> {
        return remotePagingSource
    }

}
