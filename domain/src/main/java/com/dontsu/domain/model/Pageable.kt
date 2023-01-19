package com.dontsu.domain.model

/**
 * Used for getting Digimon list.
 * */
data class Pageable(
    val currentPage: Int?,
    val elementsOnPage: Int?,
    val nextPage: String?,
    val previousPage: String?,
    val totalElements: Int?,
    val totalPages: Int?
)
