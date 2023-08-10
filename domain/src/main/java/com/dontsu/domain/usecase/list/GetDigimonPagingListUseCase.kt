package com.dontsu.domain.usecase.list

import androidx.paging.PagingSource
import com.dontsu.domain.model.Content

interface GetDigimonPagingListUseCase {
    operator fun invoke(): PagingSource<Int, Content>
}