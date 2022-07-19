package com.dontsu.domain.repository.list

import com.dontsu.domain.model.DigimonList
import kotlinx.coroutines.flow.Flow

interface DigimonListRepository {

    fun getDigimonList(pageSize: Int): Flow<DigimonList>

}
