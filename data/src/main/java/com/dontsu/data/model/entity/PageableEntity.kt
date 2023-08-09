package com.dontsu.data.model.entity

import kotlinx.serialization.Serializable

/**
 * Used for getting Digimon list.
 * */

@Serializable
data class PageableEntity(
    val currentPage: Int?,
    val elementsOnPage: Int?,
    val nextPage: String?,
    val previousPage: String?,
    val totalElements: Int?,
    val totalPages: Int?
)
