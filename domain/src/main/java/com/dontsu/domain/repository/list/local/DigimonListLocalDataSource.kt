package com.dontsu.domain.repository.list.local

import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import kotlinx.coroutines.flow.Flow

interface DigimonListLocalDataSource {
    fun getDigimonList(pageSize: Int): Flow<UiState<DigimonList>>
}
