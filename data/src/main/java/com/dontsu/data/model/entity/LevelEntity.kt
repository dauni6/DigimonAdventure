package com.dontsu.data.model.entity

import androidx.room.Entity
import com.dontsu.domain.model.Level
import javax.annotation.concurrent.Immutable

@Entity
@Immutable
data class LevelEntity(
    val id: Int?,
    val level: String?
) {
    fun mapper(): Level = Level(
        id = id,
        level = level
    )
}