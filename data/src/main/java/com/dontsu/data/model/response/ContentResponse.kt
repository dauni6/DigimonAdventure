package com.dontsu.data.model.response

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import javax.annotation.concurrent.Immutable

/**
 * Used for getting Digimon list.
 * */

@OptIn(ExperimentalSerializationApi::class)
@Immutable
@Serializable
data class ContentResponse(
    @JsonNames("href")
    val href: String?,
    @JsonNames("id")
    val id: Int?,
    @JsonNames("name")
    val name: String?,
    @JsonNames("image")
    val image: String?
)
