package com.dontsu.presentation.util

import android.os.SystemClock
import android.view.View

class OnSingleClickListener (
    private var interval: Int = 400,
    private var onSingleClick: (View) -> Unit
): View.OnClickListener {

    private var lastClickTime: Long = 0

    override fun onClick(view: View) {
        val elapsedRealtime = SystemClock.elapsedRealtime()
        if ((elapsedRealtime - lastClickTime) < interval) {
            return
        }
        lastClickTime = elapsedRealtime
        onSingleClick(view)
    }
}
