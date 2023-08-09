package com.dontsu.data.model.response

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import javax.annotation.concurrent.Immutable

@OptIn(ExperimentalSerializationApi::class)
@Immutable
@Serializable
data class NextEvolutionResponse(
    @JsonNames("condition")
    val condition: String?,
    @JsonNames("digimon")
    val digimon: String?,
    @JsonNames("id")
    val id: Int?,
    @JsonNames("image")
    val image: String?,
    @JsonNames("url")
    val url: String?
)
