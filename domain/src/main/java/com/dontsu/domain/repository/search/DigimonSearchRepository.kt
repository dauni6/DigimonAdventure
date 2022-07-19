package com.dontsu.domain.repository.search

import com.dontsu.domain.model.Digimon
import kotlinx.coroutines.flow.Flow

interface DigimonSearchRepository {

    fun searchDigimon(id: String): Flow<Digimon>

}
