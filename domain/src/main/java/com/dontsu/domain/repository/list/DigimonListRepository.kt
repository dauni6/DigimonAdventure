package com.dontsu.domain.repository.list

import androidx.paging.PagingData
import androidx.paging.PagingSource
import com.dontsu.domain.model.Content
import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import kotlinx.coroutines.flow.Flow

interface DigimonListRepository {

    fun getDigimonPagingData(): Flow<PagingData<Content>>

}
