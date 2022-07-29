package com.dontsu.data.model.entity

import javax.annotation.concurrent.Immutable

@Immutable
data class DescriptionEntity(
    val description: String?,
    val language: String?,
    val origin: String?
)
