package com.dontsu.data.mapper

import com.dontsu.data.model.entity.DescriptionEntity
import com.dontsu.data.model.response.DescriptionResponse
import com.dontsu.domain.model.Description

fun DescriptionEntity.toDescription(): Description = Description(
    description = description,
    language = language,
    origin = origin
)

fun DescriptionResponse.toDescription(): Description = Description(
    description = description,
    language = language,
    origin = origin
)

fun Description.toDescriptionEntity(): DescriptionEntity = DescriptionEntity(
    description = description,
    language = language,
    origin = origin
)
