package com.dontsu.presentation.util

import android.content.Context
import android.content.res.ColorStateList
import android.os.Build
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

class ResourcesProvider(
    private val context: Context
) {
    fun getString(@StringRes resId: Int): String = context.getString(resId)

    fun getString(@StringRes resId: Int, vararg formArg: Any): String = context.getString(resId, *formArg)

    fun getColor(@ColorRes resId: Int): Int = ContextCompat.getColor(context, resId)

    fun getColorStateList(@ColorRes resId: Int): ColorStateList? =  ContextCompat.getColorStateList(context, resId)
}