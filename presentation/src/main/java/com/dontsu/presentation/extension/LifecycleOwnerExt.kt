package com.dontsu.presentation.extension

import androidx.lifecycle.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

fun <T> LifecycleOwner.repeatOnStarted(
    flow: Flow<T>,
    block: suspend (result: T) -> Unit
) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collect {
                block(it)
            }
        }
    }
}

fun <T> LifecycleOwner.flowWithStarted(
    flow: Flow<T>,
    block: suspend (result: T) -> Unit
) {
    lifecycleScope.launch {
        flow.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED).collect {
            block(it)
        }
    }
}
