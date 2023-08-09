package com.dontsu.data.model.response

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import javax.annotation.concurrent.Immutable

@OptIn(ExperimentalSerializationApi::class)
@Immutable
@Serializable
data class FieldResponse(
    @JsonNames("field")
    val `field`: String?,
    @JsonNames("id")
    val id: Int?,
    @JsonNames("image")
    val image: String?
)
