package com.dontsu.data.model


import com.dontsu.domain.model.Description
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DescriptionResponse(
    @field:Json(name = "description")
    val description: String?,
    @field:Json(name = "language")
    val language: String?,
    @field:Json(name = "origin")
    val origin: String?
) {
    fun mapper(): Description = Description(
        description = description,
        language = language,
        origin = origin
    )
}