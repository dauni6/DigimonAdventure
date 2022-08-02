package com.dontsu.digimonadventure.extensions

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dontsu.data.util.Url.DIGIMON_IMAGE_URL

fun ImageView.loadWithName(
    name: String?
) {
    if (name.isNullOrEmpty()) return
    val newName = name.replace(" ", "_")
    Glide.with(context)
        .load("$DIGIMON_IMAGE_URL$newName.png")
        .into(this)
}

fun ImageView.loadWithUrl(
    url: String?
) {
    if (url.isNullOrEmpty()) return
    Glide.with(context)
        .load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}

fun ImageView.loadWithRes(
    @DrawableRes res: Int?
) {
    if (res == null) return
    Glide.with(context)
        .load(res)
        .into(this)
}
