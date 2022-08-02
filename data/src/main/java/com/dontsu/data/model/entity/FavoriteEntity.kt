package com.dontsu.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.annotation.concurrent.Immutable

@Entity
@Immutable
data class FavoriteEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int
)
