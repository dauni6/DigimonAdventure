package com.dontsu.domain.repository.list

import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import kotlinx.coroutines.flow.Flow

interface DigimonListRepository {

    suspend fun getDigimonList(pageSize: Int): Flow<UiState<DigimonList>>

}
