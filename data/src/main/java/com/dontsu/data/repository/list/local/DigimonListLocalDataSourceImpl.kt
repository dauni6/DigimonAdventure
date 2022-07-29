package com.dontsu.data.repository.list.local

import com.dontsu.data.db.DigimonDao
import com.dontsu.data.di.IoDispatcher
import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.list.local.DigimonListLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DigimonListLocalDataSourceImpl @Inject constructor(
    private val dao: DigimonDao,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
): DigimonListLocalDataSource {

    override fun getDigimonList(pageSize: Int): Flow<UiState<DigimonList>> = flow<UiState<DigimonList>> {


    }

}
