package com.dontsu.presentation.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun <T> LifecycleOwner.repeatOnStarted(
    flow: Flow<T>,
    block: suspend (result: T) -> Unit
) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.distinctUntilChanged().collect {
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
        flow.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED).distinctUntilChanged().collect {
            block(it)
        }
    }
}

/**
 * To handle Event for UI based on Channel
 * */
fun <T> LifecycleOwner.observeAsEvents(
    flow: Flow<T>,
    block: (T) -> Unit
) {
    lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            withContext(Dispatchers.Main.immediate) {
                flow.collect {
                    block(it)
                }
            }
        }
    }
}


/**
* @link https://developer.android.com/topic/libraries/architecture/coroutines?hl=ko#restart
* */
fun <T> Fragment.repeatOnStarted(
    flow: Flow<T>,
    block: suspend (result: T) -> Unit
) {
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.distinctUntilChanged().collect {
                block(it)
            }
        }
    }
}

fun <T> Fragment.flowWithStarted(
    flow: Flow<T>,
    block: suspend (result: T) -> Unit
) {
    viewLifecycleOwner.lifecycleScope.launch {
        flow.flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED).distinctUntilChanged().collect {
            block(it)
        }
    }
}

/**
 * To handle Event for UI based on Channel
 * */
fun <T> Fragment.observeAsEvents(
    flow: Flow<T>,
    block: (T) -> Unit
) {
    viewLifecycleOwner.lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            withContext(Dispatchers.Main.immediate) {
                flow.distinctUntilChanged().collect {
                    block(it)
                }
            }
        }
    }
}
