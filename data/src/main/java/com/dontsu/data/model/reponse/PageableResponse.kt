package com.dontsu.data.model.reponse

import com.dontsu.domain.model.Pageable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import javax.annotation.concurrent.Immutable

/**
 * Used for getting Digimon list.
 * */
@Immutable
@JsonClass(generateAdapter = true)
data class PageableResponse(
    @field:Json(name = "currentPage")
    val currentPage: Int?,
    @field:Json(name = "elementsOnPage")
    val elementsOnPage: Int?,
    @field:Json(name = "nextPage")
    val nextPage: String?,
    @field:Json(name = "previousPage")
    val previousPage: String?,
    @field:Json(name = "totalElements")
    val totalElements: Int?,
    @field:Json(name = "totalPages")
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