package com.dontsu.data.mapper

import com.dontsu.data.model.entity.PageableEntity
import com.dontsu.data.model.reponse.PageableResponse
import com.dontsu.domain.model.Pageable

fun PageableEntity.toPageable(): Pageable = Pageable(
    currentPage = currentPage,
    elementsOnPage = elementsOnPage,
    nextPage = nextPage,
    previousPage = previousPage,
    totalElements = totalElements,
    totalPages = totalPages
)

fun PageableResponse.toPageable(): Pageable = Pageable(
    currentPage = currentPage,
    elementsOnPage = elementsOnPage,
    nextPage = nextPage,
    previousPage = previousPage,
    totalElements = totalElements,
    totalPages = totalPages
)

fun Pageable.toPageableEntity(): PageableEntity = PageableEntity(
    currentPage = currentPage,
    elementsOnPage = elementsOnPage,
    nextPage = nextPage,
    previousPage = previousPage,
    totalElements = totalElements,
    totalPages = totalPages
)
