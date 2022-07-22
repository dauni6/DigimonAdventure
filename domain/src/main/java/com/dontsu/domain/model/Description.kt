package com.dontsu.domain.model

import javax.annotation.concurrent.Immutable

@Immutable
data class Description(
    val description: String?,
    val language: String?,
    val origin: String?
)
