package com.dontsu.data.mapper

import com.dontsu.data.model.entity.NextEvolutionEntity
import com.dontsu.data.model.response.NextEvolutionResponse
import com.dontsu.domain.model.NextEvolution

fun NextEvolutionEntity.toNextEvolution(): NextEvolution = NextEvolution(
    condition = condition,
    digimon = digimon,
    id = id,
    image = image,
    url = url
)

fun NextEvolutionResponse.toNextEvolution(): NextEvolution = NextEvolution(
    condition = condition,
    digimon = digimon,
    id = id,
    image = image,
    url = url
)

fun NextEvolution.toNextEvolutionEntity(): NextEvolutionEntity = NextEvolutionEntity(
    condition = condition,
    digimon = digimon,
    id = id,
    image = image,
    url = url
)
