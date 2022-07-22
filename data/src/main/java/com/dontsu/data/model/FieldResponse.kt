package com.dontsu.data.model

import com.dontsu.domain.model.Field
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
) {
    fun mapper(): Field = Field(
        field = field,
        id = id
    )
}