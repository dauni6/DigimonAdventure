package com.dontsu.data.mapper

import com.dontsu.data.model.entity.*
import com.dontsu.data.model.reponse.DigimonResponse
import com.dontsu.domain.model.Digimon

fun DigimonEntity.toDigimon(): Digimon = Digimon(
    attribute = attribute?.map { it?.toAttribute() },
    description = description?.map { it?.toDescription() },
    field = field?.map { it?.toField() },
    id = id,
    image = image?.map { it?.toImage() },
    level = level?.map { it?.toLevel() },
    name = name,
    nextEvolution = nextEvolution?.map { it?.toNextEvolution() },
    priorEvolution = priorEvolution?.map { it?.toPriorEvolution() },
    releaseDate = releaseDate,
    skills = skills?.map { it?.toSkill() },
    type = type?.map { it?.toType() },
    xAntibody = xAntibody
)

fun DigimonResponse.toDigimon(): Digimon = Digimon(
    attribute = attribute?.map { it?.toAttribute() },
    description = description?.map { it?.toDescription() },
    field = field?.map { it?.toField() },
    id = id,
    image = image?.map { it?.toImage() },
    level = level?.map { it?.toLevel() },
    name = name,
    nextEvolution = nextEvolution?.map { it?.toNextEvolution() },
    priorEvolution = priorEvolution?.map { it?.toPriorEvolution() },
    releaseDate = releaseDate,
    skills = skills?.map { it?.toSkill() },
    type = type?.map { it?.toType() },
    xAntibody = xAntibody
)

fun Digimon.toDigimonEntity(): DigimonEntity = DigimonEntity(
    attribute = attribute?.map {
        AttributeEntity(
            attribute = it?.attribute,
            id = it?.id
        )
    },
    description = description?.map {
        DescriptionEntity(
            description = it?.description,
            language = it?.language,
            origin = it?.origin
        )
    },
    field = field?.map {
        FieldEntity(
            field = it?.field,
            id = it?.id
        )
    },
    id = id,
    image = image?.map {
        ImageEntity(
            href = it?.href,
            transparent = it?.transparent
        )
    },
    level = level?.map {
        LevelEntity(
            id = it?.id,
            level = it?.level
        )
    },
    name = name,
    nextEvolution = nextEvolution?.map {
        NextEvolutionEntity(
            condition = it?.condition,
            digimon = it?.digimon,
            id = it?.id
        )
    },
    priorEvolution = priorEvolution?.map {
        PriorEvolutionEntity(
            condition = it?.condition,
            digimon = it?.digimon,
            id = it?.id
        )
    },
    releaseDate = releaseDate,
    skills = skills?.map {
        SkillEntity(
            description = it?.description,
            id = it?.id,
            skill = it?.skill,
            translation = it?.translation
        )
    },
    type = type?.map {
        TypeEntity(
            id = it?.id,
            type = it?.type
        )
    },
    xAntibody = xAntibody,
)
