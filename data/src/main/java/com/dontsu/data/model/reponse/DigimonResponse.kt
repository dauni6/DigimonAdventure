package com.dontsu.data.model.reponse

import com.dontsu.domain.model.Digimon
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
) {
    fun mapper(): Digimon = Digimon(
        attribute = attribute?.map { it?.mapper() },
        description = description?.map { it?.mapper() },
        field = field?.map { it?.mapper() },
        id = id,
        image = image?.map { it?.mapper() },
        level = level?.map { it?.mapper() },
        name = name,
        nextEvolution = nextEvolution?.map { it?.mapper() },
        priorEvolution = priorEvolution?.map { it?.mapper() },
        releaseDate = releaseDate,
        skills = skills?.map { it?.mapper() },
        type = type?.map { it?.mapper() },
        xAntibody = xAntibody
    )
}
