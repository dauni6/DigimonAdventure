package com.dontsu.data.repository.list.remote

import androidx.annotation.WorkerThread
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dontsu.data.exception.EmptyResponseBodyException
import com.dontsu.data.mapper.toDigimonList
import com.dontsu.data.network.DigimonApi
import com.dontsu.domain.model.Content
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import kotlin.math.max

private const val START_PAGE = 0

class DigimonListRemotePagingSource @Inject constructor(
    private val api: DigimonApi,
) : PagingSource<Int, Content>() {

    @WorkerThread
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Content> {
        val page = params.key ?: START_PAGE
        return try {
            val response = api.getDigimonList(page = page, pageSize = params.loadSize).getOrThrow()
            val digimonList = response.toDigimonList()
            digimonList.content?.let { list ->
                val contents = list.filterNotNull()
                LoadResult.Page(
                    data = contents,
                    prevKey = if (page == START_PAGE) null else page - 1,
                    nextKey = if (list.isEmpty()) null else page + 1
                )
            } ?: kotlin.run {
                throw EmptyResponseBodyException()
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
