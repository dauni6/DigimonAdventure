package com.dontsu.digimonadventure.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.dontsu.domain.model.Digimon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    val digimonId: String = savedStateHandle[DetailActivity.DIGIMON_ID_KEY]
        ?: throw IllegalStateException("There is no value of the digimon id.")

}
