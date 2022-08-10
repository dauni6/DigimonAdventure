package com.dontsu.data.mapper

import com.dontsu.data.model.entity.ContentEntity
import com.dontsu.data.model.response.ContentResponse
import com.dontsu.domain.model.Content

fun ContentEntity.toContent(): Content = Content(
    href = href,
    id = id,
    name = name
)

fun ContentResponse.toContent(): Content = Content(
    href = href,
    id = id,
    name = name
)

fun Content.toContentEntity(): ContentEntity = ContentEntity(
    href = href,
    id = id,
    name = name
)