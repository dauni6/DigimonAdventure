package com.dontsu.data.repository.list

import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.repository.list.DigimonListRepository
import kotlinx.coroutines.flow.Flow

class DigimonListRepositoryImpl: DigimonListRepository {

    override fun getDigimonList(pageSize: Int): Flow<DigimonList> {

    }

}
