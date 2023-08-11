package com.dontsu.domain.usecase.list

import androidx.paging.PagingData
import com.dontsu.domain.model.Content
import kotlinx.coroutines.flow.Flow

interface GetDigimonPagingListUseCase {
    operator fun invoke(): Flow<PagingData<Content>>
}