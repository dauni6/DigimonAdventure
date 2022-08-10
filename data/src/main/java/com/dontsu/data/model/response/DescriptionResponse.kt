package com.dontsu.data.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import javax.annotation.concurrent.Immutable

@Immutable
@JsonClass(generateAdapter = true)
data class DescriptionResponse(
    @field:Json(name = "description")
    val description: String?,
    @field:Json(name = "language")
    val language: String?,
    @field:Json(name = "origin")
    val origin: String?
)