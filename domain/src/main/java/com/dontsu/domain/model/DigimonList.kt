package com.dontsu.domain.model

import javax.annotation.concurrent.Immutable

/**
 * Used for getting Digimon list.
 * */
@Immutable
data class DigimonList(
    val content: List<Content?>?,
    val pageable: Pageable? // Not used in this project.
)