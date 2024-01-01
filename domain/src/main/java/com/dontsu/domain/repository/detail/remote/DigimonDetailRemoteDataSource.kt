package com.dontsu.domain.repository.detail.remote

import com.dontsu.domain.model.Digimon

interface DigimonDetailRemoteDataSource {
    suspend fun getDigimon(id: Int): Digimon
}
