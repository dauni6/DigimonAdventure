package com.dontsu.data.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import javax.annotation.concurrent.Immutable

@Immutable
@JsonClass(generateAdapter = true)
data class DigimonResponse(
    @field:Json(name = "attributes")
    val attribute: List<AttributeResponse?>?,
    @field:Json(name = "descriptions")
    val description: List<DescriptionResponse?>?,
    @field:Json(name = "fields")
    val field: List<FieldResponse?>?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "images")
    val image: List<ImageResponse?>?,
    @field:Json(name = "levels")
    val level: List<LevelResponse?>?,
    @field:Json(name = "name")
    val name: String?,
    @field:Json(name = "nextEvolutions")
    val nextEvolution: List<NextEvolutionResponse?>?,
    @field:Json(name = "priorEvolutions")
    val priorEvolution: List<PriorEvolutionResponse?>?,
    @field:Json(name = "releaseDate")
    val releaseDate: String?,
    @field:Json(name = "skills")
    val skills: List<SkillResponse?>?,
    @field:Json(name = "types")
    val type: List<TypeResponse?>?,
    @field:Json(name = "xAntibody")
    val xAntibody: Boolean?
)
