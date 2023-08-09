package com.dontsu.data.model.response

import kotlinx.serialization.Serializable
import javax.annotation.concurrent.Immutable

@Immutable
@Serializable
data class DescriptionResponse(
    val description: String?,
    val language: String?,
    val origin: String?
)