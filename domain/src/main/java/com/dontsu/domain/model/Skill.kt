package com.dontsu.domain.model

import javax.annotation.concurrent.Immutable

@Immutable
data class Skill(
    val description: String?,
    val id: Int?,
    val skill: String?,
    val translation: String?
)
