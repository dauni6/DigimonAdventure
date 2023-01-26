package com.dontsu.presentation.extensions

import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

fun LifecycleOwner.repeatOnStarted(block: suspend CoroutineScope.() -> Unit) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            block()
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
