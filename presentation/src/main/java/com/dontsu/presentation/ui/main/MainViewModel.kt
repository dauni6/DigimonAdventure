package com.dontsu.presentation.ui.main

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.dontsu.domain.model.Content
import com.dontsu.presentation.ui.base.BaseViewModel
import com.dontsu.domain.model.UiState
import com.dontsu.domain.usecase.list.GetDigimonPagingListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class MainViewModel @Inject constructor(
    pagingListUseCase: GetDigimonPagingListUseCase
) : BaseViewModel() {

    val pagingListStateFlow: StateFlow<UiState<PagingData<Content>>> = pagingListUseCase.invoke()
    .cachedIn(viewModelScope)
    .mapLatest {
        UiState.Success(it)
    }
    .stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = UiState.Loading
    )

    private val _refresh: MutableStateFlow<UiState<Boolean>> = MutableStateFlow(UiState.Uninitialized)
    val refresh: StateFlow<UiState<Boolean>> = _refresh.asStateFlow()

    fun refreshDigimonList() {
        _refresh.update { UiState.Loading }
        _refresh.update { UiState.Success(true) }
    }

}
