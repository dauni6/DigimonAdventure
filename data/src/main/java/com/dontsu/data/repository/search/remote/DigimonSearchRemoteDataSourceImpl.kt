package com.dontsu.data.repository.search.remote

import com.dontsu.data.network.DigimonApi
import com.dontsu.domain.model.Digimon
import com.dontsu.domain.repository.search.remote.DigimonSearchRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DigimonSearchRemoteDataSourceImpl @Inject constructor(
    private val api: DigimonApi
): DigimonSearchRemoteDataSource {

    override fun searchDigimon(id: Int): Flow<Digimon> {
        TODO("Not yet implemented")
    }

}
