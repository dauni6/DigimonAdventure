package com.dontsu.data.model.entity

import javax.annotation.concurrent.Immutable

@Immutable
data class PriorEvolutionEntity(
    val condition: String?,
    val digimon: String?,
    val id: Int?
)
