package com.dontsu.domain.model

import javax.annotation.concurrent.Immutable

@Immutable
data class Attribute(
    val attribute: String?,
    val id: Int?
)
