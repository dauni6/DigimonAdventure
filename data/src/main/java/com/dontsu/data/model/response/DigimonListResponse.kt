package com.dontsu.data.model.response

import kotlinx.serialization.Serializable
import javax.annotation.concurrent.Immutable

/**
 * Used for getting Digimon list.
 * */
@Immutable
@Serializable
data class DigimonListResponse(
    val content: List<ContentResponse?>? = null,
    val pageable: PageableResponse? // Not used in this project.
)
