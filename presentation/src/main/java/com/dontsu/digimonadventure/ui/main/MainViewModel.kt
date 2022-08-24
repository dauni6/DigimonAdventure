package com.dontsu.digimonadventure.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dontsu.domain.model.Content
import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import com.dontsu.domain.usecase.list.GetDigimonListUseCase
import com.dontsu.domain.usecase.search.GetDigimonSearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val listUseCase: GetDigimonListUseCase,
    private val searchUseCase: GetDigimonSearchUseCase
) : ViewModel() {

    // for digimon list
    private val _listUiState = listUseCase.invoke(pageSize = 100).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = UiState.Loading
    )
    var listUiState: StateFlow<UiState<DigimonList>> = _listUiState

    // for search list
    private val _digimonUiState: MutableStateFlow<UiState<DigimonList>> = MutableStateFlow(UiState.Uninitialized)
    val digimonUiState: StateFlow<UiState<DigimonList>> = _digimonUiState.asStateFlow()

    private val _refresh: MutableStateFlow<UiState<Boolean>> = MutableStateFlow(UiState.Uninitialized)
    val refresh: StateFlow<UiState<Boolean>> = _refresh.asStateFlow()

    fun searchDigimon(name: String) = viewModelScope.launch {
        _digimonUiState.value = UiState.Loading
        searchUseCase.invoke(name = name).collect {
            _digimonUiState.value = it
        }
    }

    fun refresh() = viewModelScope.launch {
        _refresh.value = UiState.Loading
        delay(4000)

        _refresh.value = UiState.Success(true)
    }

}
