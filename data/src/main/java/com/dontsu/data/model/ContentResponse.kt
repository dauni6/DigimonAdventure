package com.dontsu.data.model

import com.dontsu.domain.model.Content
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Used for getting Digimon list.
 * */
@JsonClass(generateAdapter = true)
data class ContentResponse(
    @field:Json(name = "href")
    val href: String?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "name")
    val name: String?
) {
    fun mapper(): Content = Content(
        href = href,
        id = id,
        name = name
    )
}
