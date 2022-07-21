package com.dontsu.digimonadventure.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import com.dontsu.domain.usecase.list.GetDigimonListUseCase
import com.dontsu.domain.usecase.search.GetDigimonSearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val listUseCase: GetDigimonListUseCase,
    private val searchUsecase: GetDigimonSearchUseCase
) : ViewModel() {

    // for digimon list
    private val _listUiState: MutableStateFlow<UiState<DigimonList>> = MutableStateFlow(UiState.Uninitialized)
    val listUiState: StateFlow<UiState<DigimonList>> = _listUiState.asStateFlow()

    // for single digimon
    private val _digimonUiState: MutableStateFlow<UiState<Digimon>> = MutableStateFlow(UiState.Uninitialized)
    val digimonUiState: StateFlow<UiState<Digimon>> = _digimonUiState.asStateFlow()

    init {
        viewModelScope.launch {
            Timber.d("MainViewModel init... ${Thread.currentThread()} / ${this.coroutineContext}")
            _listUiState.value = UiState.Loading
            listUseCase.invoke(pageSize = 100).collect { _listUiState.value = it }
        }
    }

    fun searchDigimon(name: String) = viewModelScope.launch {

    }

}
