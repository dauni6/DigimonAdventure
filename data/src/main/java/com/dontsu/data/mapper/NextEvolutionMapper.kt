package com.dontsu.data.mapper

import com.dontsu.data.model.entity.NextEvolutionEntity
import com.dontsu.data.model.reponse.NextEvolutionResponse
import com.dontsu.domain.model.NextEvolution

fun toNextEvolution(nextEvolutionResponse: NextEvolutionEntity?): NextEvolution = NextEvolution(
    condition = nextEvolutionResponse?.condition,
    digimon = nextEvolutionResponse?.digimon,
    id = nextEvolutionResponse?.id
)

fun toNextEvolution(nextEvolutionResponse: NextEvolutionResponse?): NextEvolution = NextEvolution(
    condition = nextEvolutionResponse?.condition,
    digimon = nextEvolutionResponse?.digimon,
    id = nextEvolutionResponse?.id
)

fun toNextEvolutionEntity(nextEvolution: NextEvolution): NextEvolutionEntity = NextEvolutionEntity(
    condition = nextEvolution.condition,
    digimon = nextEvolution.digimon,
    id = nextEvolution.id
)
