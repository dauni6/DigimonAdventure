package com.dontsu.domain.model

import javax.annotation.concurrent.Immutable

/**
 * Used for getting Digimon list.
 * */
@Immutable
data class Content(
    val href: String?,
    val id: Int?,
    val name: String?
)
