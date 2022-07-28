package com.dontsu.data.model.reponse

import com.dontsu.domain.model.PriorEvolution
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
) {
    fun mapper(): PriorEvolution = PriorEvolution(
        condition = condition,
        digimon = digimon,
        id = id
    )
}