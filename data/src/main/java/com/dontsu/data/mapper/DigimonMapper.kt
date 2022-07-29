package com.dontsu.data.mapper

import com.dontsu.data.model.entity.*
import com.dontsu.data.model.reponse.DigimonResponse
import com.dontsu.domain.model.Digimon

fun toDigimon(digimon: DigimonEntity): Digimon = Digimon(
    attribute = digimon.attribute?.map { toAttribute(it) },
    description = digimon.description?.map { toDescription(it) },
    field = digimon.field?.map { toField(it) },
    id = digimon.id,
    image = digimon.image?.map { toImage(it) },
    level = digimon.level?.map { toLevel(it) },
    name = digimon.name,
    nextEvolution = digimon.nextEvolution?.map { toNextEvolution(it) },
    priorEvolution = digimon.priorEvolution?.map { toPriorEvolution(it) },
    releaseDate = digimon.releaseDate,
    skills = digimon.skills?.map { toSkill(it) },
    type = digimon.type?.map { toType(it) },
    xAntibody = digimon.xAntibody
)

fun toDigimon(digimon: DigimonResponse?): Digimon = Digimon(
    attribute = digimon?.attribute?.map { toAttribute(it) },
    description = digimon?.description?.map { toDescription(it) },
    field = digimon?.field?.map { toField(it) },
    id = digimon?.id,
    image = digimon?.image?.map { toImage(it) },
    level = digimon?.level?.map { toLevel(it) },
    name = digimon?.name,
    nextEvolution = digimon?.nextEvolution?.map { toNextEvolution(it) },
    priorEvolution = digimon?.priorEvolution?.map { toPriorEvolution(it) },
    releaseDate = digimon?.releaseDate,
    skills = digimon?.skills?.map { toSkill(it) },
    type = digimon?.type?.map { toType(it) },
    xAntibody = digimon?.xAntibody
)

fun toDigimonEntity(digimon: Digimon): DigimonEntity = DigimonEntity(
    attribute = digimon.attribute?.map {
        AttributeEntity(
            attribute = it?.attribute,
            id = it?.id
        )
    },
    description = digimon.description?.map {
        DescriptionEntity(
            description = it?.description,
            language = it?.language,
            origin = it?.origin
        )
    },
    field = digimon.field?.map {
        FieldEntity(
            field = it?.field,
            id = it?.id
        )
    },
    id = digimon.id,
    image = digimon.image?.map {
        ImageEntity(
            href = it?.href,
            transparent = it?.transparent
        )
    },
    level = digimon.level?.map {
        LevelEntity(
            id = it?.id,
            level = it?.level
        )
    },
    name = digimon.name,
    nextEvolution = digimon.nextEvolution?.map {
        NextEvolutionEntity(
            condition = it?.condition,
            digimon = it?.digimon,
            id = it?.id
        )
    },
    priorEvolution = digimon.priorEvolution?.map {
        PriorEvolutionEntity(
            condition = it?.condition,
            digimon = it?.digimon,
            id = it?.id
        )
    },
    releaseDate = digimon.releaseDate,
    skills = digimon.skills?.map {
        SkillEntity(
            description = it?.description,
            id = it?.id,
            skill = it?.skill,
            translation = it?.translation
        )
    },
    type = digimon.type?.map {
        TypeEntity(
            id = it?.id,
            type = it?.type
        )
    },
    xAntibody = digimon.xAntibody,
)
