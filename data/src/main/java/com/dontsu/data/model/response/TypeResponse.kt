package com.dontsu.data.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import javax.annotation.concurrent.Immutable

@Immutable
@JsonClass(generateAdapter = true)
data class TypeResponse(
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "type")
    val type: String?
)
