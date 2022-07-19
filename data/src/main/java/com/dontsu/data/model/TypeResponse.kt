package com.dontsu.data.model


import com.dontsu.domain.model.Type
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TypeResponse(
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "type")
    val type: String?
) {
    fun mapper(): Type = Type(
        id = id,
        type = type
    )
}