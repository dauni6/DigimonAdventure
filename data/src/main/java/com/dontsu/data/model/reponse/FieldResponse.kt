package com.dontsu.data.model.reponse

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import javax.annotation.concurrent.Immutable

@Immutable
@JsonClass(generateAdapter = true)
data class FieldResponse(
    @field:Json(name = "field")
    val `field`: String?,
    @field:Json(name = "id")
    val id: Int?
)
