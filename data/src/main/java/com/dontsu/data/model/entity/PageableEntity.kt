package com.dontsu.data.model.entity

import androidx.room.Entity
import com.dontsu.domain.model.Pageable
import javax.annotation.concurrent.Immutable

/**
 * Used for getting Digimon list.
 * */
@Entity
@Immutable
data class PageableEntity(
    val currentPage: Int?,
    val elementsOnPage: Int?,
    val nextPage: String?,
    val previousPage: String?,
    val totalElements: Int?,
    val totalPages: Int?
) {
    fun mapper(): Pageable = Pageable(
        currentPage = currentPage,
        elementsOnPage = elementsOnPage,
        nextPage = nextPage,
        previousPage = previousPage,
        totalElements = totalElements,
        totalPages = totalPages
    )
}