package com.dontsu.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity
data class FavoriteEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int
)
