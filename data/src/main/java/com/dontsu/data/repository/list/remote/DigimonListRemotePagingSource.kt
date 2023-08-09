package com.dontsu.data.repository.list.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dontsu.data.network.DigimonApi
import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

private const val START_PAGE = 0

class DigimonListRemotePagingSource @Inject constructor(
    private val api: DigimonApi,
    private val ioDispatcher: CoroutineDispatcher
) : PagingSource<Int, UiState<DigimonList>>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UiState<DigimonList>> {
        val page = params.key ?: START_PAGE

        val response = api.getDigimonList(page = page, pageSize = params.loadSize)

    }

    override fun getRefreshKey(state: PagingState<Int, UiState<DigimonList>>): Int? {

    }

}
