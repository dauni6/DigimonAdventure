package com.dontsu.data.model.entity

import javax.annotation.concurrent.Immutable

@Immutable
data class ImageEntity(
    val href: String?,
    val transparent: Boolean?
)
