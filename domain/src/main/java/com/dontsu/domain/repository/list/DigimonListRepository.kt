package com.dontsu.domain.repository.list

import androidx.paging.PagingData
import com.dontsu.domain.model.Content
import kotlinx.coroutines.flow.Flow

interface DigimonListRepository {

    fun getDigimonPagingData(): Flow<PagingData<Content>>

}
