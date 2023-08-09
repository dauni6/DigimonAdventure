package com.dontsu.data.model.entity

import kotlinx.serialization.Serializable

@Serializable
data class FieldEntity(
    val `field`: String?,
    val id: Int?,
    val image: String?
)
