package com.dontsu.data.mapper

import com.dontsu.data.model.entity.ContentEntity
import com.dontsu.data.model.reponse.ContentResponse
import com.dontsu.domain.model.Content

fun toContent(content: ContentEntity?): Content = Content(
    href = content?.href,
    id = content?.id,
    name = content?.name
)

fun toContent(content: ContentResponse?): Content = Content(
    href = content?.href,
    id = content?.id,
    name = content?.name
)

fun toContentEntity(content: Content): ContentEntity = ContentEntity(
    href = content.href,
    id = content.id,
    name = content.name
)