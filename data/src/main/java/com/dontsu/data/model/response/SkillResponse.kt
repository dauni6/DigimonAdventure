package com.dontsu.data.model.response

import kotlinx.serialization.Serializable
import javax.annotation.concurrent.Immutable

@Immutable
@Serializable
data class SkillResponse(
    val description: String?,
    val id: Int?,
    val skill: String?,
    val translation: String?
)
