package com.dontsu.digimonadventure.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.UiState
import com.dontsu.domain.usecase.detail.GetDigimonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    detailUseCase: GetDigimonDetailUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val digimonId: Int = savedStateHandle[DetailActivity.DIGIMON_ID_KEY]
        ?: throw IllegalStateException("There is no value of the digimon id.")

    val uiState: StateFlow<UiState<Digimon>> = detailUseCase.invoke(id = digimonId).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = UiState.Loading
    )

}
