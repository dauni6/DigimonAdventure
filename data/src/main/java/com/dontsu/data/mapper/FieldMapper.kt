package com.dontsu.data.mapper

import com.dontsu.data.model.entity.FieldEntity
import com.dontsu.data.model.response.FieldResponse
import com.dontsu.domain.model.Field

fun FieldEntity.toField(): Field = Field(
    field = field,
    id = id,
    image = image
)

fun FieldResponse.toField(): Field = Field(
    field = field,
    id = id,
    image = image
)

fun Field.toFieldEntity(): FieldEntity = FieldEntity(
    field = field,
    id = id,
    image = image
)
