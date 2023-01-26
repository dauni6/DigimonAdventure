package com.dontsu.presentation.ui.main

import androidx.lifecycle.viewModelScope
import com.dontsu.presentation.ui.base.BaseViewModel
import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import com.dontsu.domain.usecase.list.GetDigimonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import kotlin.random.Random
import kotlin.random.nextInt

private const val DEFAULT_ITEM_SIZE = 100

@ExperimentalCoroutinesApi
@HiltViewModel
class MainViewModel @Inject constructor(
    private val listUseCase: GetDigimonListUseCase
) : BaseViewModel() {

    // for digimon list
    private var itemSize = 100
    private val _listUiState: MutableStateFlow<UiState<DigimonList>> = MutableStateFlow(UiState.Loading)
    val listUiState: StateFlow<UiState<DigimonList>> = _listUiState.flatMapLatest {
        if (_listUiState.value == UiState.Uninitialized) {
            throw CancellationException()
        }
        listUseCase.invoke(pageSize = itemSize)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = UiState.Loading
    )

    private val _refresh: MutableStateFlow<UiState<Boolean>> = MutableStateFlow(UiState.Uninitialized)
    val refresh: StateFlow<UiState<Boolean>> = _refresh.asStateFlow()

    fun refreshDigimonList() {
        itemSize = Random.nextInt(1..30)
        _refresh.value = UiState.Loading
        _listUiState.value = UiState.Uninitialized
        _listUiState.value = UiState.Loading
        _refresh.value = UiState.Success(true)
    }

}
