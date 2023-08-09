package com.dontsu.data.model.entity

import kotlinx.serialization.Serializable

@Serializable
data class AttributeEntity(
    val attribute: String?,
    val id: Int?
)
