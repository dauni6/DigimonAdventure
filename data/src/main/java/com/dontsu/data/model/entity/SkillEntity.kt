package com.dontsu.data.model.entity

import kotlinx.serialization.Serializable

@Serializable
data class SkillEntity(
    val description: String?,
    val id: Int?,
    val skill: String?,
    val translation: String?
)
