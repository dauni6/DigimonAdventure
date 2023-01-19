package com.dontsu.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DigimonEntity(
    val attribute: List<AttributeEntity?>?,
    val description: List<DescriptionEntity?>?,
    val field: List<FieldEntity?>?,
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    val image: List<ImageEntity?>?,
    val level: List<LevelEntity?>?,
    val name: String?,
    val nextEvolution: List<NextEvolutionEntity?>?,
    val priorEvolution: List<PriorEvolutionEntity?>?,
    val releaseDate: String?,
    val skills: List<SkillEntity?>?,
    val type: List<TypeEntity?>?,
    val xAntibody: Boolean?
)
