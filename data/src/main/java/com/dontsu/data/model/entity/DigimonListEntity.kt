package com.dontsu.data.model.entity

import javax.annotation.concurrent.Immutable

/**
 * Used for getting Digimon list from Room.
 * */
@Immutable
data class DigimonListEntity(
    val content: List<ContentEntity?>?,
    val pageable: PageableEntity? // Not used in this project.
)
