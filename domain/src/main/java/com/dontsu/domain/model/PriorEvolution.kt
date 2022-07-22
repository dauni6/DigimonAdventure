package com.dontsu.domain.model

import javax.annotation.concurrent.Immutable

@Immutable
data class PriorEvolution(
    val condition: String?,
    val digimon: String?,
    val id: Int?
)
