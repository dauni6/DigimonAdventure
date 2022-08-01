package com.dontsu.data.mapper

import com.dontsu.data.model.entity.ContentEntity
import com.dontsu.data.model.entity.DigimonListEntity
import com.dontsu.data.model.entity.PageableEntity
import com.dontsu.data.model.reponse.DigimonListResponse
import com.dontsu.domain.model.DigimonList

fun DigimonListEntity.toDigimonList(): DigimonList = DigimonList(
    content = content?.map { it?.toContent() },
    pageable = pageable?.toPageable()
)

fun DigimonListResponse.toDigimonList(): DigimonList = DigimonList(
    content = content?.map { it?.toContent() },
    pageable = pageable?.toPageable()
)

fun DigimonList.toEntity(): DigimonListEntity = DigimonListEntity(
    content = content?.map {
        ContentEntity(
            id = it?.id,
            href = it?.href,
            name = it?.name
        )
    },
    pageable = PageableEntity(
        currentPage = pageable?.currentPage,
        elementsOnPage = pageable?.elementsOnPage,
        nextPage = pageable?.nextPage,
        previousPage = pageable?.previousPage,
        totalElements = pageable?.totalElements,
        totalPages = pageable?.totalPages
    )
)