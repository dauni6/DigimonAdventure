package com.dontsu.data.model.entity

/**
 * Used for getting Digimon list.
 * */
data class PageableEntity(
    val currentPage: Int?,
    val elementsOnPage: Int?,
    val nextPage: String?,
    val previousPage: String?,
    val totalElements: Int?,
    val totalPages: Int?
)
