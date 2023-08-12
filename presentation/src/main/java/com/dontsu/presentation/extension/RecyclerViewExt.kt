package com.dontsu.presentation.extension

import android.util.DisplayMetrics
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.android.awaitFrame

private const val DEFAULT_JUMP_THRESHOLD = 30
private const val DEFAULT_SPEED_FACTOR = 1f

/**
 * Smooth scroll to the top of the list, but if the distance is long,
 * first jump closer to the target and then start the scroll.
 * @param jumpThreshold the maximum number of items to scroll past
 * @param speedFactor modify the speed of the smooth scroll
 *
 * reference : https://medium.com/flat-pack-tech/quickly-scroll-to-the-top-of-a-recyclerview-da15b717f3c4
 */
suspend fun RecyclerView.quickScrollToTop(
    jumpThreshold: Int = DEFAULT_JUMP_THRESHOLD,
    speedFactor: Float = DEFAULT_SPEED_FACTOR
) {
    val layoutManager = layoutManager as? LinearLayoutManager
        ?: error("Need to be used with a LinearLayoutManager or subclass of it")

    val smoothScroller = object : LinearSmoothScroller(context) {
        init {
            targetPosition = 0
        }

        override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics?) =
            super.calculateSpeedPerPixel(displayMetrics) / speedFactor
    }

    val jumpBeforeScroll = layoutManager.findFirstVisibleItemPosition() > jumpThreshold
    if (jumpBeforeScroll) {
        layoutManager.scrollToPositionWithOffset(jumpThreshold, 0)
        awaitFrame()
    }

    layoutManager.startSmoothScroll(smoothScroller)
}
