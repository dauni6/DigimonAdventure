package com.dontsu.presentation.ui.main

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
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
    private val pagingListUseCase: GetDigimonPagingListUseCase
) : BaseViewModel() {

    val pagingListStateFlow: StateFlow<UiState<PagingData<Content>>> = Pager(
        config = PagingConfig(
            pageSize = DEFAULT_PAGE_SIZE,
            enablePlaceholders = false
        )
    ) {
        pagingListUseCase.invoke()
    }.flow
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

/*    fun refreshDigimonList() {
        itemSize = Random.nextInt(1..30)
        _refresh.value = UiState.Loading
        _listUiState.value = UiState.Uninitialized
        _listUiState.value = UiState.Loading
        _refresh.value = UiState.Success(true)
    }*/

    companion object {
        const val DEFAULT_PAGE_SIZE = 20
    }

}
