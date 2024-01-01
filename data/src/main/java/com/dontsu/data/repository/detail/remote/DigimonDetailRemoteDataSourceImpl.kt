package com.dontsu.data.repository.detail.remote

import androidx.annotation.WorkerThread
import com.dontsu.data.mapper.toDigimon
import com.dontsu.data.network.DigimonApi
import com.dontsu.domain.model.Digimon
import com.dontsu.domain.repository.detail.remote.DigimonDetailRemoteDataSource
import javax.inject.Inject

/**
 * DigimonDetailRemoteDataSourceImpl which practically requests and gets the single digimon data from api.
 * */
class DigimonDetailRemoteDataSourceImpl @Inject constructor(
    private val api: DigimonApi,
): DigimonDetailRemoteDataSource {

    @WorkerThread
    override suspend fun getDigimon(id: Int): Digimon = api.getDigimon(id = id).getOrThrow().toDigimon()

}
