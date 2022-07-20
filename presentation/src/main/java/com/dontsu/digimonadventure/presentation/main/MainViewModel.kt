package com.dontsu.digimonadventure.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dontsu.domain.model.DigimonList
import com.dontsu.domain.model.UiState
import com.dontsu.domain.usecase.list.GetDigimonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val listUseCase: GetDigimonListUseCase
) : ViewModel() {

    private val _uiState:MutableStateFlow<UiState<DigimonList>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<DigimonList>> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            listUseCase.invoke(100).collect {
                _uiState.value = it
            }
        }
    }

}
