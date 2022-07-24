package com.dontsu.digimonadventure.ui.main

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
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    listUseCase: GetDigimonListUseCase,
    private val searchUseCase: GetDigimonSearchUseCase
) : ViewModel() {

    // for digimon list
    private val _listUiState = listUseCase.invoke(pageSize = 100).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = UiState.Loading
    )
    val listUiState: StateFlow<UiState<DigimonList>> = _listUiState

    // for search list
    private val _digimonUiState: MutableStateFlow<UiState<DigimonList>> = MutableStateFlow(UiState.Loading)
    val digimonUiState: StateFlow<UiState<DigimonList>> = _digimonUiState.asStateFlow()

    fun searchDigimon(name: String) = viewModelScope.launch {
        searchUseCase.invoke(name = name).collect {
            _digimonUiState.value = it
        }
    }

}
