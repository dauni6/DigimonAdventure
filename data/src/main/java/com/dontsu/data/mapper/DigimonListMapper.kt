package com.dontsu.data.mapper

import com.dontsu.data.model.entity.ContentEntity
import com.dontsu.data.model.entity.DigimonListEntity
import com.dontsu.data.model.entity.PageableEntity
import com.dontsu.data.model.reponse.DigimonListResponse
import com.dontsu.domain.model.DigimonList

fun toDigimonList(digimonList: DigimonListEntity): DigimonList = DigimonList(
    content = digimonList.content?.map { toContent(it) },
    pageable = toPageable(digimonList.pageable)
)

fun toDigimonList(digimonList: DigimonListResponse?): DigimonList = DigimonList(
    content = digimonList?.content?.map { toContent(it) },
    pageable = toPageable(digimonList?.pageable)
)

fun toEntity(digimonList: DigimonList): DigimonListEntity = DigimonListEntity(
    content = digimonList.content?.map {
        ContentEntity(
            id = it?.id,
            href = it?.href,
            name = it?.name
        )
    },
    pageable = PageableEntity(
        currentPage = digimonList.pageable?.currentPage,
        elementsOnPage = digimonList.pageable?.elementsOnPage,
        nextPage = digimonList.pageable?.nextPage,
        previousPage = digimonList.pageable?.previousPage,
        totalElements = digimonList.pageable?.totalElements,
        totalPages = digimonList.pageable?.totalPages
    )
)