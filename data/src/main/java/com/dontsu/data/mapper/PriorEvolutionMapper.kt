package com.dontsu.data.mapper

import com.dontsu.data.model.entity.PriorEvolutionEntity
import com.dontsu.data.model.response.PriorEvolutionResponse
import com.dontsu.domain.model.PriorEvolution

fun PriorEvolutionEntity.toPriorEvolution(): PriorEvolution = PriorEvolution(
    condition = condition,
    digimon = digimon,
    id = id,
    image = image,
    url = url
)

fun PriorEvolutionResponse.toPriorEvolution(): PriorEvolution = PriorEvolution(
    condition = condition,
    digimon = digimon,
    id = id,
    image = image,
    url = url
)

fun PriorEvolution.toPriorEvolutionEntity(): PriorEvolutionEntity = PriorEvolutionEntity(
    condition = condition,
    digimon = digimon,
    id = id,
    image = image,
    url = url
)
