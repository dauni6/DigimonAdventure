package com.dontsu.data.model.response

import kotlinx.serialization.Serializable
import javax.annotation.concurrent.Immutable

@Immutable
@Serializable
data class TypeResponse(
    val id: Int?,
    val type: String?
)
