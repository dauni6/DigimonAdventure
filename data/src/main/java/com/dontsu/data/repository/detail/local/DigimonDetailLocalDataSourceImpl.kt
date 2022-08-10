package com.dontsu.data.repository.detail.local

import androidx.annotation.WorkerThread
import com.dontsu.data.db.DigimonDao
import com.dontsu.data.di.IoDispatcher
import com.dontsu.data.exceptions.EmptyLocalDataException
import com.dontsu.data.mapper.toDigimon
import com.dontsu.data.mapper.toDigimonEntity
import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.detail.local.DigimonDetailLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DigimonDetailLocalDataSourceImpl @Inject constructor(
    private val dao: DigimonDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
): DigimonDetailLocalDataSource {

    @WorkerThread
    override suspend fun getDigimon(id: Int): UiState<Digimon> {
        return try {
            val digimon = dao.getDigimon(id = id)
            if (digimon == null) {
                throw EmptyLocalDataException("There is no digimon for this id.")
            } else {
                UiState.Success(digimon.toDigimon())
            }
        } catch (e: Exception) {
            UiState.Error(e)
        }
    }

    @WorkerThread
    override suspend fun insertDigimon(digimon: Digimon) = withContext(ioDispatcher) {
        dao.insertDigimon(digimon = digimon.toDigimonEntity())
    }

}
