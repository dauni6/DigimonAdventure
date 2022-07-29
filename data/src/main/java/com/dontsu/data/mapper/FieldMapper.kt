package com.dontsu.data.mapper

import com.dontsu.data.model.entity.FieldEntity
import com.dontsu.data.model.reponse.FieldResponse
import com.dontsu.domain.model.Field

fun toField(field: FieldEntity?): Field = Field(
    field = field?.field,
    id = field?.id
)

fun toField(field: FieldResponse?): Field = Field(
    field = field?.field,
    id = field?.id
)

fun toFieldEntity(field: Field): FieldEntity = FieldEntity(
    field = field.field,
    id = field.id
)
