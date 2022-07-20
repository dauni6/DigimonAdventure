package com.dontsu.digimonadventure.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dontsu.digimonadventure.presentation.base.UiState
import com.dontsu.domain.model.successOrNull
import com.dontsu.domain.usecase.list.GetDigimonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val listUseCase: GetDigimonListUseCase
) : ViewModel() {

    init {
        viewModelScope.launch {
            val list = listUseCase.invoke(100)
            list.collect {
                it.successOrNull()?.content?.forEach {
                    Timber.d("id = ${it?.id} / name = ${it?.name} / href = ${it?.href}")
                }
            }
        }
    }

}
