package com.dontsu.domain.repository.list.remote

import com.dontsu.domain.model.DigimonList
import kotlinx.coroutines.flow.Flow

interface DigimonListRemoteDataSource {
    fun getDigimonList(pageSize: Int): Flow<DigimonList>
}
