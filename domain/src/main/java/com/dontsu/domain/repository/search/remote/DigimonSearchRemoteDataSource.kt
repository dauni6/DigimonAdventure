package com.dontsu.domain.repository.search.remote

import com.dontsu.domain.model.Digimon
import kotlinx.coroutines.flow.Flow

interface DigimonSearchRemoteDataSource {
    fun searchDigimon(id: String): Flow<Digimon>
}
