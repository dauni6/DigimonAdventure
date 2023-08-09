package com.dontsu.data.model.response

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import javax.annotation.concurrent.Immutable

@OptIn(ExperimentalSerializationApi::class)
@Immutable
@Serializable
data class ImageResponse(
    @JsonNames("href")
    val href: String?,
    @JsonNames("transparent")
    val transparent: Boolean?
)
