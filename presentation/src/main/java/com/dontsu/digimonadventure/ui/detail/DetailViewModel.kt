package com.dontsu.digimonadventure.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState
import com.dontsu.domain.usecase.detail.GetDigimonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    detailUseCase: GetDigimonDetailUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val digimonId: Int = savedStateHandle[DetailActivity.DIGIMON_ID_KEY]
        ?: throw IllegalStateException("There is no value of the digimon id.")

    private val _uiState: MutableStateFlow<UiState<Digimon>> = MutableStateFlow(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            flow {
                emit(detailUseCase.invoke(id = digimonId))
            }.stateIn(this).collectLatest {
                _uiState.value = it
            }
        }
    }

}
