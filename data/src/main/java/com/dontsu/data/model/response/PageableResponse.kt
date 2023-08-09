package com.dontsu.data.model.response

import kotlinx.serialization.Serializable
import javax.annotation.concurrent.Immutable

/**
 * Used for getting Digimon list.
 * */
@Immutable
@Serializable
data class PageableResponse(
    val currentPage: Int?,
    val elementsOnPage: Int?,
    val nextPage: String?,
    val previousPage: String?,
    val totalElements: Int?,
    val totalPages: Int?
)
