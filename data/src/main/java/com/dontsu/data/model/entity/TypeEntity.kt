package com.dontsu.data.model.entity

import javax.annotation.concurrent.Immutable

@Immutable
data class TypeEntity(
    val id: Int?,
    val type: String?
)
