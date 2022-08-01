package com.dontsu.data.mapper

import com.dontsu.data.model.entity.PriorEvolutionEntity
import com.dontsu.data.model.reponse.PriorEvolutionResponse
import com.dontsu.domain.model.PriorEvolution

fun PriorEvolutionEntity.toPriorEvolution(): PriorEvolution = PriorEvolution(
    condition = condition,
    digimon = digimon,
    id = id
)

fun PriorEvolutionResponse.toPriorEvolution(): PriorEvolution = PriorEvolution(
    condition = condition,
    digimon = digimon,
    id = id
)

fun PriorEvolution.toPriorEvolutionEntity(): PriorEvolutionEntity = PriorEvolutionEntity(
    condition = condition,
    digimon = digimon,
    id = id
)
