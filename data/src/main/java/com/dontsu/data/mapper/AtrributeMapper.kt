package com.dontsu.data.mapper

import com.dontsu.data.model.entity.AttributeEntity
import com.dontsu.data.model.reponse.AttributeResponse
import com.dontsu.domain.model.Attribute

fun toAttribute(attribute: AttributeEntity?): Attribute = Attribute(
    attribute = attribute?.attribute,
    id = attribute?.id
)

fun toAttribute(attribute: AttributeResponse?): Attribute = Attribute(
    attribute = attribute?.attribute,
    id = attribute?.id
)

fun toAttributeEntity(attribute: Attribute): AttributeEntity = AttributeEntity(
    attribute = attribute.attribute,
    id = attribute.id
)
