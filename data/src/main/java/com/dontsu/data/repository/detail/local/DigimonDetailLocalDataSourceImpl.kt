package com.dontsu.data.repository.detail.local

import androidx.annotation.WorkerThread
import com.dontsu.data.db.DigimonDao
import com.dontsu.data.exception.EmptyLocalDataException
import com.dontsu.data.mapper.toDigimon
import com.dontsu.data.mapper.toDigimonEntity
import com.dontsu.data.mapper.toFavorite
import com.dontsu.data.mapper.toFavoriteEntity
import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.Favorite
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.detail.local.DigimonDetailLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DigimonDetailLocalDataSourceImpl @Inject constructor(
    private val dao: DigimonDao,
    private val ioDispatcher: CoroutineDispatcher
): DigimonDetailLocalDataSource {

    @WorkerThread
    override suspend fun getDigimon(id: Int): Digimon {
        val digimon = dao.getDigimon(id = id)
        return digimon?.toDigimon() ?: throw EmptyLocalDataException("There is no digimon for this id.")
    }

    @WorkerThread
    override suspend fun insertDigimon(digimon: Digimon) = withContext(ioDispatcher) {
        dao.insertDigimon(digimon = digimon.toDigimonEntity())
    }

    @WorkerThread
    override suspend fun addFavorite(favorite: Favorite) = withContext(ioDispatcher) {
        dao.addFavorite(favorite = favorite.toFavoriteEntity())
    }

    @WorkerThread
    override fun getFavorite(id: Int): Flow<UiState<Favorite>> = flow<UiState<Favorite>> {
        val favorite = dao.getFavorite(id = id)
        favorite.collect {
            if (it == null) {
                throw EmptyLocalDataException("There is no data for this id.")
            } else {
                emit(UiState.Success(it.toFavorite()))
            }
        }
    }
    .flowOn(ioDispatcher)
    .catch {
        emit(UiState.Error(it))
    }

    @WorkerThread
    override suspend fun deleteFavorite(favorite: Favorite) = withContext(ioDispatcher) {
        dao.deleteFavorite(favorite = favorite.toFavoriteEntity())
    }
}
