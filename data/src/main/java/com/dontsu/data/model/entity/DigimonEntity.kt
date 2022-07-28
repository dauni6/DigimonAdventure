package com.dontsu.data.model.entity

import androidx.room.Entity
import com.dontsu.domain.model.Digimon
import javax.annotation.concurrent.Immutable

@Entity
@Immutable
data class DigimonEntity(
    val attribute: List<AttributeEntity?>?,
    val description: List<DescriptionEntity?>?,
    val field: List<FieldEntity?>?,
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
