package com.dontsu.domain.model

import javax.annotation.concurrent.Immutable

@Immutable
data class Level(
    val id: Int?,
    val level: String?
)
