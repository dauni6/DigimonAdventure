package com.dontsu.data.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import javax.annotation.concurrent.Immutable

@Immutable
@JsonClass(generateAdapter = true)
data class PriorEvolutionResponse(
    @field:Json(name = "condition")
    val condition: String?,
    @field:Json(name = "digimon")
    val digimon: String?,
    @field:Json(name = "id")
    val id: Int?
)
