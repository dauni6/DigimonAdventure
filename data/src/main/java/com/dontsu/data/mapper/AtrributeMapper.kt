package com.dontsu.data.mapper

import com.dontsu.data.model.entity.AttributeEntity
import com.dontsu.data.model.reponse.AttributeResponse
import com.dontsu.domain.model.Attribute

fun AttributeEntity.toAttribute(): Attribute = Attribute(
    attribute = attribute,
    id = id
)

fun AttributeResponse.toAttribute(): Attribute = Attribute(
    attribute = attribute,
    id = id
)

fun Attribute.toAttributeEntity(): AttributeEntity = AttributeEntity(
    attribute = attribute,
    id = id
)
