package com.dontsu.data.model.reponse

import com.dontsu.domain.model.NextEvolution
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import javax.annotation.concurrent.Immutable

@Immutable
@JsonClass(generateAdapter = true)
data class NextEvolutionResponse(
    @field:Json(name = "condition")
    val condition: String?,
    @field:Json(name = "digimon")
    val digimon: String?,
    @field:Json(name = "id")
    val id: Int?
) {
    fun mapper(): NextEvolution = NextEvolution(
        condition = condition,
        digimon = digimon,
        id = id
    )
}