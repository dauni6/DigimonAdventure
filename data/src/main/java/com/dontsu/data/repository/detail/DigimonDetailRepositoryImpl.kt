package com.dontsu.data.repository.detail

import com.dontsu.data.di.IoDispatcher
import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.detail.DigimonDetailRepository
import com.dontsu.domain.repository.detail.local.DigimonDetailLocalDataSource
import com.dontsu.domain.repository.detail.remote.DigimonDetailRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DigimonDetailRepositoryImpl @Inject constructor(
    private val remoteDataSource: DigimonDetailRemoteDataSource,
    private val localDataSource: DigimonDetailLocalDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
): DigimonDetailRepository {

    override fun getDigimon(id: Int): Flow<UiState<Digimon>> {
        val digimonFromDB = localDataSource.getDigimon(id = id)
        val digimon = remoteDataSource.getDigimon(id = id)
        return digimon
    }

}
