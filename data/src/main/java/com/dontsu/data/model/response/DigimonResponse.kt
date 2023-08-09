package com.dontsu.data.model.response

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames
import javax.annotation.concurrent.Immutable

@OptIn(ExperimentalSerializationApi::class)
@Immutable
@Serializable
data class DigimonResponse(
    @JsonNames("attributes")
    val attribute: List<AttributeResponse?>?,
    @JsonNames("descriptions")
    val description: List<DescriptionResponse?>?,
    @JsonNames("fields")
    val field: List<FieldResponse?>?,
    @JsonNames("id")
    val id: Int?,
    @JsonNames("images")
    val image: List<ImageResponse?>?,
    @JsonNames("levels")
    val level: List<LevelResponse?>?,
    @JsonNames("name")
    val name: String?,
    @JsonNames("nextEvolutions")
    val nextEvolution: List<NextEvolutionResponse?>?,
    @JsonNames("priorEvolutions")
    val priorEvolution: List<PriorEvolutionResponse?>?,
    @JsonNames("releaseDate")
    val releaseDate: String?,
    @JsonNames("skills")
    val skills: List<SkillResponse?>?,
    @JsonNames("types")
    val type: List<TypeResponse?>?,
    @JsonNames("xAntibody")
    val xAntibody: Boolean?
)
