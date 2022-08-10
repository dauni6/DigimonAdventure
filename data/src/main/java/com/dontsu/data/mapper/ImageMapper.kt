package com.dontsu.data.mapper

import com.dontsu.data.model.entity.ImageEntity
import com.dontsu.data.model.response.ImageResponse
import com.dontsu.domain.model.Image

fun ImageEntity.toImage(): Image = Image(
    href = href,
    transparent = transparent
)

fun ImageResponse.toImage(): Image = Image(
    href = href,
    transparent = transparent
)

fun Image.toImageEntity(): ImageEntity = ImageEntity(
    href = href,
    transparent = transparent
)
