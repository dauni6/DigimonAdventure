package com.dontsu.data.model.response

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
)
