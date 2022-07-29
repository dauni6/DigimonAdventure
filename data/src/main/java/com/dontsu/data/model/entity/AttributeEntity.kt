package com.dontsu.data.model.entity

import javax.annotation.concurrent.Immutable

@Immutable
data class AttributeEntity(
    val attribute: String?,
    val id: Int?
)
