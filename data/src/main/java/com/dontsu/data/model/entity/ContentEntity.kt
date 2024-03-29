package com.dontsu.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

/**
 * Used for getting Digimon list from Room.
 * */

@Serializable
@Entity
data class ContentEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    val href: String?,
    val name: String?,
    val image: String?
)
