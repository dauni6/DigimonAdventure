package com.dontsu.presentation.ui.main

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dontsu.presentation.extensions.dpToPx


class DigimonAdapterItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position: Int = parent.getChildAdapterPosition(view)
        val itemCount = state.itemCount

        val space = view.context.dpToPx(ITEM_SPACE)

        // bottom
        if (position > 0 && position < itemCount - 2) {
            outRect.bottom = space
        }

        // right
        // spanIndex = 0 -> left item / spanIndex = 1 -> right item
        val lp = view.layoutParams as GridLayoutManager.LayoutParams
        val spanIndex = lp.spanIndex
        if (spanIndex == 0) {
            outRect.right = space / 2
        }

    }

    companion object {
        private const val ITEM_SPACE = 15f
    }

}
