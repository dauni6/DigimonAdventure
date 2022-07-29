package com.dontsu.data.mapper

import com.dontsu.data.model.entity.PriorEvolutionEntity
import com.dontsu.data.model.reponse.PriorEvolutionResponse
import com.dontsu.domain.model.PriorEvolution

fun toPriorEvolution(priorEvolutionResponse: PriorEvolutionEntity?): PriorEvolution = PriorEvolution(
    condition = priorEvolutionResponse?.condition,
    digimon = priorEvolutionResponse?.digimon,
    id = priorEvolutionResponse?.id
)

fun toPriorEvolution(priorEvolutionResponse: PriorEvolutionResponse?): PriorEvolution = PriorEvolution(
    condition = priorEvolutionResponse?.condition,
    digimon = priorEvolutionResponse?.digimon,
    id = priorEvolutionResponse?.id
)

fun toPriorEvolutionEntity(priorEvolution: PriorEvolution): PriorEvolutionEntity = PriorEvolutionEntity(
    condition = priorEvolution.condition,
    digimon = priorEvolution.digimon,
    id = priorEvolution.id
)
