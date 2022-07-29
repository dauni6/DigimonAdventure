package com.dontsu.data.model.entity

import javax.annotation.concurrent.Immutable

@Immutable
data class LevelEntity(
    val id: Int?,
    val level: String?
)
