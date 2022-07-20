package com.dontsu.data.repository.list.remote

import com.dontsu.data.exceptions.EmptyBodyException
import com.dontsu.data.exceptions.NetworkFailureException
import com.dontsu.data.model.DigimonListResponse
import com.dontsu.data.network.DigimonApi
import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.list.remote.DigimonListRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DigimonListRemoteDataSourceImpl @Inject constructor(
    private val api: DigimonApi
): DigimonListRemoteDataSource {

    override suspend fun getDigimonList(pageSize: Int): Flow<UiState<DigimonList>> = flow<UiState<DigimonList>> {
        val response = api.getDigimonList(pageSize = pageSize)
        if (response.isSuccessful) {
            val digimons: DigimonListResponse = response.body() ?: throw EmptyBodyException("[${response.code()}] - ${response.raw()}")
            emit(UiState.Success(digimons.mapper()))
        } else {
            throw NetworkFailureException("[${response.code()}] - ${response.raw()}")
        }
    }.catch {
        emit(UiState.Error(it))
    }

}
