package com.dontsu.data.mapper

import com.dontsu.data.model.entity.TypeEntity
import com.dontsu.data.model.reponse.TypeResponse
import com.dontsu.domain.model.Type

fun toType(type: TypeEntity?): Type = Type(
    id = type?.id,
    type = type?.type
)

fun toType(type: TypeResponse?): Type = Type(
    id = type?.id,
    type = type?.type
)

fun totypeEntity(type: Type): TypeEntity = TypeEntity(
    id = type.id,
    type = type.type
)
