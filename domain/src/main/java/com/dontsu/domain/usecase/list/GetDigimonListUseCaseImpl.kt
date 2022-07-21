package com.dontsu.domain.usecase.list

import android.util.Log
import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import com.dontsu.domain.repository.list.DigimonListRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class GetDigimonListUseCaseImpl @Inject constructor(
    private val repository: DigimonListRepository
): GetDigimonListUseCase {
    override fun invoke(pageSize: Int): Flow<UiState<DigimonList>> {
        Log.d("TEST", "GetDigimonListUseCaseImpl / ${Thread.currentThread()}")
        return repository.getDigimonList(pageSize = pageSize)
    }
}
