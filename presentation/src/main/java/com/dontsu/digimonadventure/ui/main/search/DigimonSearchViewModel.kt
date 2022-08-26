package com.dontsu.digimonadventure.ui.main.search

import androidx.lifecycle.viewModelScope
import com.dontsu.digimonadventure.ui.base.BaseViewModel
import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import com.dontsu.domain.usecase.search.GetDigimonSearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DigimonSearchViewModel @Inject constructor(
    private val searchUseCase: GetDigimonSearchUseCase
): BaseViewModel() {

    // for search list
    private val _digimonUiState: MutableStateFlow<UiState<DigimonList>> = MutableStateFlow(UiState.Uninitialized)
    val digimonUiState: StateFlow<UiState<DigimonList>> = _digimonUiState.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = UiState.Loading
    )

    fun searchDigimon(name: String) = viewModelScope.launch {
        _digimonUiState.value = UiState.Loading
        searchUseCase.invoke(name = name).collect {
            _digimonUiState.value = it
        }
    }

}
