package com.dontsu.presentation.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dontsu.domain.model.Digimon
import com.dontsu.domain.model.Favorite
import com.dontsu.domain.model.UiState
import com.dontsu.domain.model.successOrNull
import com.dontsu.domain.usecase.detail.*
import com.dontsu.presentation.R
import com.dontsu.presentation.util.ResourcesProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class DetailViewModel @Inject constructor(
    getDetailUseCase: GetDigimonDetailUseCaseImpl,
    private val addFavoriteUseCase: AddDigimonDetailFavoriteUseCaseImpl,
    getFavoriteUseCase: GetDigimonDetailFavoriteUseCaseImpl,
    private val deleteFavoriteUseCase: DeleteDigimonDetailFavoriteUseCaseImpl,
    resourcesProvider: ResourcesProvider, // Using ResourceProvider for getString resource in ViewModel would be not a good way because of using context. but it would be okay if we don't use ResourceProvider to get theme.
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val digimonId: Int = savedStateHandle[DetailActivity.DIGIMON_ID_KEY]
        ?: throw IllegalStateException(resourcesProvider.getString(R.string.no_value_of_id))

    private val _uiState: MutableStateFlow<UiState<Digimon>> = MutableStateFlow(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            flow {
                emit(getDetailUseCase.invoke(id = digimonId))
            }.stateIn(this).collectLatest { digimon ->
                _uiState.update { UiState.Success(digimon) }
            }
        }
    }

    private val _isFavorite: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isFavorite = _isFavorite.asStateFlow()

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
