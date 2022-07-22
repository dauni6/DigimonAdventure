package com.dontsu.domain.model

import javax.annotation.concurrent.Immutable

@Immutable
data class Field(
    val `field`: String?,
    val id: Int?
)
