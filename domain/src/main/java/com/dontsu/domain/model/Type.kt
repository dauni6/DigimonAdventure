package com.dontsu.domain.model

import javax.annotation.concurrent.Immutable

@Immutable
data class Type(
    val id: Int?,
    val type: String?
)
