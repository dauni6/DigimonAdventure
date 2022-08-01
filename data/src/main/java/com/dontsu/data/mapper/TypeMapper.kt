package com.dontsu.data.mapper

import com.dontsu.data.model.entity.TypeEntity
import com.dontsu.data.model.reponse.TypeResponse
import com.dontsu.domain.model.Type

fun TypeEntity.toType(): Type = Type(
    id = id,
    type = type
)

fun TypeResponse.toType(): Type = Type(
    id = id,
    type = type
)

fun Type.totypeEntity(): TypeEntity = TypeEntity(
    id = id,
    type = type
)
