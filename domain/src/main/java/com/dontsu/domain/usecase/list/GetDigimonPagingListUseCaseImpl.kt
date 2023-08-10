package com.dontsu.domain.usecase.list

import androidx.paging.PagingSource
import com.dontsu.domain.model.Content
import com.dontsu.domain.repository.list.DigimonListRepository
import javax.inject.Inject

class GetDigimonPagingListUseCaseImpl @Inject constructor(
    private val repository: DigimonListRepository
): GetDigimonPagingListUseCase {

    override fun invoke(): PagingSource<Int, Content> {
        return repository.getDigimonList()
    }

}
