package com.dontsu.data.mapper

import com.dontsu.data.model.entity.PageableEntity
import com.dontsu.data.model.reponse.PageableResponse
import com.dontsu.domain.model.Pageable

fun toPageable(pageableResponse: PageableEntity?): Pageable = Pageable(
    currentPage = pageableResponse?.currentPage,
    elementsOnPage = pageableResponse?.elementsOnPage,
    nextPage = pageableResponse?.nextPage,
    previousPage = pageableResponse?.previousPage,
    totalElements = pageableResponse?.totalElements,
    totalPages = pageableResponse?.totalPages
)

fun toPageable(pageableResponse: PageableResponse?): Pageable = Pageable(
    currentPage = pageableResponse?.currentPage,
    elementsOnPage = pageableResponse?.elementsOnPage,
    nextPage = pageableResponse?.nextPage,
    previousPage = pageableResponse?.previousPage,
    totalElements = pageableResponse?.totalElements,
    totalPages = pageableResponse?.totalPages
)

fun toPageableEntity(pageable: Pageable): PageableEntity = PageableEntity(
    currentPage = pageable.currentPage,
    elementsOnPage = pageable.elementsOnPage,
    nextPage = pageable.nextPage,
    previousPage = pageable.previousPage,
    totalElements = pageable.totalElements,
    totalPages = pageable.totalPages
)
