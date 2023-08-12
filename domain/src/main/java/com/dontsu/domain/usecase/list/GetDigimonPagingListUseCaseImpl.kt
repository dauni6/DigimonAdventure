package com.dontsu.domain.usecase.list

import androidx.paging.PagingData
import com.dontsu.domain.model.Content
import com.dontsu.domain.repository.list.DigimonListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDigimonPagingListUseCaseImpl @Inject constructor(
    private val repository: DigimonListRepository
): GetDigimonPagingListUseCase {

    override fun invoke(): Flow<PagingData<Content>> {
        return repository.getDigimonPagingData()
    }

}
