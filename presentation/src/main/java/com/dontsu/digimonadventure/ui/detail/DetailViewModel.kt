package com.dontsu.digimonadventure.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.Favorite
import com.dontsu.domain.model.UiState
import com.dontsu.domain.model.successOrNull
import com.dontsu.domain.usecase.detail.AddDigimonDetailFavoriteUseCase
import com.dontsu.domain.usecase.detail.DeleteDigimonDetailFavoriteUseCase
import com.dontsu.domain.usecase.detail.GetDigimonDetailFavoriteUseCase
import com.dontsu.domain.usecase.detail.GetDigimonDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class DetailViewModel @Inject constructor(
    getDetailUseCase: GetDigimonDetailUseCase,
    private val addFavoriteUseCase: AddDigimonDetailFavoriteUseCase,
    getFavoriteUseCase: GetDigimonDetailFavoriteUseCase,
    private val deleteFavoriteUseCase: DeleteDigimonDetailFavoriteUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val digimonId: Int = savedStateHandle[DetailActivity.DIGIMON_ID_KEY]
        ?: throw IllegalStateException("There is no value of the digimon id.")

    val uiState: StateFlow<UiState<Digimon>> = getDetailUseCase.invoke(id = digimonId).stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = UiState.Loading
    )

    private val _isFavorite: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isFavorite = _isFavorite.asStateFlow()
//    val isFavorite: StateFlow<Boolean> = getFavoriteUseCase.invoke(id = digimonId).map { state ->
//        state.successOrNull()?.id == digimonId
//    }.stateIn(
//        scope = viewModelScope,
//        started = SharingStarted.WhileSubscribed(5000),
//        initialValue = false
//    )

    init {
        viewModelScope.launch {
            getFavoriteUseCase.invoke(id = digimonId).map { state ->
                state.successOrNull()?.id == digimonId
            }.collect {
                _isFavorite.value = it
            }
        }
    }

    fun addFavorite() = viewModelScope.launch {
        _isFavorite.value = true
        addFavoriteUseCase.invoke(favorite = Favorite(digimonId))
    }

    fun deleteFavorite() = viewModelScope.launch {
        _isFavorite.value = false
        deleteFavoriteUseCase.invoke(favorite = Favorite((digimonId)))
    }

}
