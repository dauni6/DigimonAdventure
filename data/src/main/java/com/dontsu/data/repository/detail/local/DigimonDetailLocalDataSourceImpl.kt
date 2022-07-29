package com.dontsu.data.repository.detail.local

import android.util.Log
import androidx.annotation.WorkerThread
import com.dontsu.data.db.DigimonDao
import com.dontsu.data.di.IoDispatcher
import com.dontsu.data.mapper.toDigimon
import com.dontsu.data.mapper.toDigimonEntity
import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.detail.local.DigimonDetailLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DigimonDetailLocalDataSourceImpl @Inject constructor(
    private val dao: DigimonDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
): DigimonDetailLocalDataSource {

    @WorkerThread
    override fun getDigimon(id: Int): Flow<UiState<Digimon>> {
        Log.d("TEST", "getDigimom() impl datasource")
        val digimon = dao.getDigimon(id = id)
        return digimon.mapNotNull {
            Log.d("TEST", "datasource it = $it")
            UiState.Success(toDigimon(it))
        }.catch {
            Log.d("TEST", "datasource error")
        }
    }

    @WorkerThread
    override suspend fun insertDigimon(digimon: Digimon) = withContext(ioDispatcher) {
        dao.insertDigimon(digimon = toDigimonEntity(digimon))
    }

}
