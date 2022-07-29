package com.dontsu.data.model.entity

import javax.annotation.concurrent.Immutable

@Immutable
data class FieldEntity(
    val `field`: String?,
    val id: Int?
)
