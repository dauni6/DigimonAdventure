package com.dontsu.data.repository.list

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dontsu.data.network.DigimonApi
import com.dontsu.data.repository.list.remote.DigimonListRemotePagingSource
import com.dontsu.domain.model.Content
import com.dontsu.domain.repository.list.DigimonListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DigimonListRepositoryImpl @Inject constructor(
    private val api: DigimonApi,
): DigimonListRepository {

    override fun getDigimonPagingData(): Flow<PagingData<Content>> {
        return Pager(
            config = PagingConfig(
                pageSize = DEFAULT_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                DigimonListRemotePagingSource(api = api)
            }
        ).flow
    }

    companion object {
        const val DEFAULT_PAGE_SIZE = 20
    }

}
