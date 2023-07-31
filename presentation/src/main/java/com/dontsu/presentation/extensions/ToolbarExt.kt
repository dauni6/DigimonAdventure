package com.dontsu.presentation.extensions

import androidx.annotation.ColorInt
import androidx.appcompat.widget.Toolbar

fun Toolbar.setNavigationIconColor(@ColorInt color: Int) = navigationIcon?.mutate()?.let {
    it.setTint(color)
    this.navigationIcon = it
}