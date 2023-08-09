package com.dontsu.data.model.entity

import kotlinx.serialization.Serializable


/**
 * Used for getting Digimon list from Room.
 * */

@Serializable
data class DigimonListEntity(
    val content: List<ContentEntity?>?,
    val pageable: PageableEntity? // Not used in this project.
)
