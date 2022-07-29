package com.dontsu.data.mapper

import com.dontsu.data.model.entity.ImageEntity
import com.dontsu.data.model.reponse.ImageResponse
import com.dontsu.domain.model.Image

fun toImage(image: ImageEntity?): Image = Image(
    href = image?.href,
    transparent = image?.transparent
)

fun toImage(image: ImageResponse?): Image = Image(
    href = image?.href,
    transparent = image?.transparent
)

fun toImageEntity(image: Image): ImageEntity = ImageEntity(
    href = image.href,
    transparent = image.transparent
)
