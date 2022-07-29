package com.dontsu.data.mapper

import com.dontsu.data.model.entity.DescriptionEntity
import com.dontsu.data.model.reponse.DescriptionResponse
import com.dontsu.domain.model.Description

fun toDescription(description: DescriptionEntity?): Description = Description(
    description = description?.description,
    language = description?.language,
    origin = description?.origin
)

fun toDescription(description: DescriptionResponse?): Description = Description(
    description = description?.description,
    language = description?.language,
    origin = description?.origin
)

fun toDescriptionEntity(description: Description): DescriptionEntity = DescriptionEntity(
    description = description.description,
    language = description.language,
    origin = description.origin
)
