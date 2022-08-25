package com.dontsu.data.repository.detail.remote

import androidx.annotation.WorkerThread
import com.dontsu.data.di.IoDispatcher
import com.dontsu.data.exceptions.EmptyBodyException
import com.dontsu.data.exceptions.NetworkFailureException
import com.dontsu.data.mapper.toDigimon
import com.dontsu.data.model.response.DigimonResponse
import com.dontsu.data.network.DigimonApi
import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.detail.remote.DigimonDetailRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * DigimonDetailRemoteDataSourceImpl which practically requests and gets the single digimon data from api.
 * */
class DigimonDetailRemoteDataSourceImpl @Inject constructor(
    private val api: DigimonApi,
    @IoDispatcher val ioDispatcher: CoroutineDispatcher
): DigimonDetailRemoteDataSource {

    @WorkerThread
    override suspend fun getDigimon(id: Int): UiState<Digimon> = withContext(ioDispatcher) {
        try {
            val response = api.getDigimon(id = id)
            if (response.isSuccessful) {
                val digimon: DigimonResponse = response.body() ?: throw EmptyBodyException("[error code : ${response.code()}] -> ${response.raw()}")
                UiState.Success(digimon.toDigimon())
            } else {
                throw NetworkFailureException("[${response.code()}] - ${response.raw()}")
            }
        } catch (e: Exception) {
            UiState.Error(e)
        }
    }

}
