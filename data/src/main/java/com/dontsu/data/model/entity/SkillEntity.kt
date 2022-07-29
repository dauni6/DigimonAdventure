package com.dontsu.data.model.entity

import javax.annotation.concurrent.Immutable

@Immutable
data class SkillEntity(
    val description: String?,
    val id: Int?,
    val skill: String?,
    val translation: String?
)
