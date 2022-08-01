package com.dontsu.data.repository.search.remote

import androidx.annotation.WorkerThread
import com.dontsu.data.di.IoDispatcher
import com.dontsu.data.exceptions.EmptyBodyException
import com.dontsu.data.exceptions.NetworkFailureException
import com.dontsu.data.mapper.toDigimonList
import com.dontsu.data.model.reponse.DigimonListResponse
import com.dontsu.data.network.DigimonApi
import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.search.remote.DigimonSearchRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * DigimonSearchRemoteDataSourceImpl which practically requests and gets the single data from api.
 * */
class DigimonSearchRemoteDataSourceImpl @Inject constructor(
    private val api: DigimonApi,
    @IoDispatcher val ioDispatcher: CoroutineDispatcher
): DigimonSearchRemoteDataSource {

    @WorkerThread
    override fun searchDigimon(name: String): Flow<UiState<DigimonList>> = flow<UiState<DigimonList>> {
        val response = api.searchDigimon(name = name)
        if (response.isSuccessful) {
            val digimons: DigimonListResponse = response.body() ?: throw EmptyBodyException("[error code : ${response.code()}] -> ${response.raw()}")
            emit(UiState.Success(digimons.toDigimonList()))
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
