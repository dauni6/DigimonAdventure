package com.dontsu.data.model

import com.dontsu.domain.model.Attribute
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import javax.annotation.concurrent.Immutable

@Immutable
@JsonClass(generateAdapter = true)
data class AttributeResponse(
    @Json(name = "attribute")
    val attribute: String?,
    @field:Json(name = "id")
    val id: Int?
) {
    fun mapper(): Attribute = Attribute(
        attribute = attribute,
        id = id
    )
}