package com.dontsu.data.model.reponse

import com.dontsu.domain.model.Content
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import javax.annotation.concurrent.Immutable

/**
 * Used for getting Digimon list.
 * */
@Immutable
@JsonClass(generateAdapter = true)
data class ContentResponse(
    @field:Json(name = "href")
    val href: String?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "name")
    val name: String?
)
