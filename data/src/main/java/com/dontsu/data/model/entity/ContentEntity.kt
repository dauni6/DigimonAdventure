package com.dontsu.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.concurrent.Immutable

/**
 * Used for getting Digimon list from Room.
 * */
@Entity
@Immutable
data class ContentEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    val href: String?,
    val name: String?
)
