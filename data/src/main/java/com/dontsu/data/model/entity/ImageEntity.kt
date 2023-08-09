package com.dontsu.data.model.entity

import kotlinx.serialization.Serializable

@Serializable
data class ImageEntity(
    val href: String?,
    val transparent: Boolean?
)
