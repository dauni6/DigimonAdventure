package com.dontsu.presentation.extensions

import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.dontsu.presentation.util.OnSingleClickListener

fun View.toVisible(visible: Boolean = true) {
    isVisible = visible
}

fun View.toInvisible() {
    isVisible = false
}

fun View.toGone(gone: Boolean = true) {
    isGone = gone
}

fun View.setOnSingleClickListener(onSingleClick: (View) -> Unit) {
    val singleClick = OnSingleClickListener {
        onSingleClick(it)
    }
    setOnClickListener(singleClick)
}
