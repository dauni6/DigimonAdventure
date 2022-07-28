package com.dontsu.data.repository.detail.remote

import androidx.annotation.WorkerThread
import com.dontsu.data.di.IoDispatcher
import com.dontsu.data.exceptions.EmptyBodyException
import com.dontsu.data.exceptions.NetworkFailureException
import com.dontsu.data.model.reponse.DigimonResponse
import com.dontsu.data.network.DigimonApi
import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.detail.remote.DigimonDetailRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * DigimonDetailRemoteDataSourceImpl which practically requests and gets the single digimon data from api.
 * */
class DigimonDetailRemoteDataSourceImpl @Inject constructor(
    private val api: DigimonApi,
    @IoDispatcher val ioDispatcher: CoroutineDispatcher
): DigimonDetailRemoteDataSource {

    @WorkerThread
    override fun getDigimon(id: Int): Flow<UiState<Digimon>> = flow<UiState<Digimon>> {
        val response = api.getDigimon(id = id)
        if (response.isSuccessful) {
            val digimon: DigimonResponse = response.body() ?: throw EmptyBodyException("[error code : ${response.code()}] -> ${response.raw()}")
            emit(UiState.Success(digimon.mapper()))
        } else {
            throw NetworkFailureException("[${response.code()}] - ${response.raw()}")
        }
    }
    // flowOn affects the upstreeam flow ↑. So, the flow builder above is going to run in the `io` dispatcher.
    .flowOn(ioDispatcher)
    // The downstream flow ↓ is not affected by io dispatcher. So, it's still affected by consumer's context.
    // In this case, it means ViewModelScope's coroutineContext where the business logic is started.
    // Therefore, it runs in `main` dispatcher because the default dispatcher of ViewModelScope is `Dispatchers.Main.immediate`.
    .catch {
        emit(UiState.Error(it))
    }

}
