package com.dontsu.data.model

import com.dontsu.domain.model.Image
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import javax.annotation.concurrent.Immutable

@Immutable
@JsonClass(generateAdapter = true)
data class ImageResponse(
    @field:Json(name = "href")
    val href: String?,
    @field:Json(name = "transparent")
    val transparent: Boolean?
) {
    fun mapper(): Image = Image(
        href = href,
        transparent = transparent
    )
}