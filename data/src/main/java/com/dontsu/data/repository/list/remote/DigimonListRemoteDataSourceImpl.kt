package com.dontsu.data.repository.list.remote

import androidx.annotation.WorkerThread
import com.dontsu.data.exceptions.EmptyBodyException
import com.dontsu.data.exceptions.NetworkFailureException
import com.dontsu.data.mapper.toDigimonList
import com.dontsu.data.model.response.DigimonListResponse
import com.dontsu.data.network.DigimonApi
import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.list.remote.DigimonListRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * DigimonListRemoteDataSourceImpl which practically requests and gets the data list from api.
 * */
class DigimonListRemoteDataSourceImpl @Inject constructor(
    private val api: DigimonApi,
    private val ioDispatcher: CoroutineDispatcher
): DigimonListRemoteDataSource {

    @WorkerThread
    override fun getDigimonList(pageSize: Int): Flow<UiState<DigimonList>> = flow<UiState<DigimonList>> {
        val response = api.getDigimonList(pageSize = pageSize)
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
