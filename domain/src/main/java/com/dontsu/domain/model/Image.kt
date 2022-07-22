package com.dontsu.domain.model

import javax.annotation.concurrent.Immutable

@Immutable
data class Image(
    val href: String?,
    val transparent: Boolean?
)
