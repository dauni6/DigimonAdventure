package com.dontsu.data.model.entity

import kotlinx.serialization.Serializable

@Serializable
data class PriorEvolutionEntity(
    val condition: String?,
    val digimon: String?,
    val id: Int?,
    val image: String?,
    val url: String?
)
