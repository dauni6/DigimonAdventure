package com.dontsu.data.model.entity

import kotlinx.serialization.Serializable

@Serializable
data class LevelEntity(
    val id: Int?,
    val level: String?
)
