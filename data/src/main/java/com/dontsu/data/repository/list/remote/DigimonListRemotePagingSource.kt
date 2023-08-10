package com.dontsu.data.repository.list.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dontsu.data.exceptions.EmptyBodyException
import com.dontsu.data.mapper.toDigimonList
import com.dontsu.data.model.response.DigimonListResponse
import com.dontsu.data.network.DigimonApi
import com.dontsu.domain.model.Content
import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import kotlin.math.max

private const val START_PAGE = 0

class DigimonListRemotePagingSource @Inject constructor(
    private val api: DigimonApi,
    private val ioDispatcher: CoroutineDispatcher
) : PagingSource<Int, Content>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Content> {
        val page = params.key ?: START_PAGE
        return try {
            val response = api.getDigimonList(page = page, pageSize = params.loadSize)
            if (response.isSuccessful) {
                val digimonResponse: DigimonListResponse = response.body() ?: throw EmptyBodyException("[error code : ${response.code()}] -> ${response.raw()}")
                val digimonList = digimonResponse.toDigimonList()
                digimonList.content?.let { list ->
                    val contents = list.filterNotNull()
                    LoadResult.Page(
                        data = contents,
                        prevKey = if (page == START_PAGE) null else page - 1,
                        nextKey = if (list.isEmpty()) null else page + 1
                    )
                } ?: kotlin.run {
                    throw EmptyBodyException("[error code : ${response.code()}] -> ${response.raw()}")
                }
            } else {
                throw EmptyBodyException("[error code : ${response.code()}] -> ${response.raw()}")
            }
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Content>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val content = state.closestItemToPosition(anchorPosition) ?: return null
        val id = content.id ?: 0
        return ensureValidKey(key = id  - (state.config.pageSize / 2))
    }

    private fun ensureValidKey(key: Int) = max(START_PAGE, key)

}
