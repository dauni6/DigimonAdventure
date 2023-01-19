package com.dontsu.data.model.entity

/**
 * Used for getting Digimon list from Room.
 * */
data class DigimonListEntity(
    val content: List<ContentEntity?>?,
    val pageable: PageableEntity? // Not used in this project.
)
