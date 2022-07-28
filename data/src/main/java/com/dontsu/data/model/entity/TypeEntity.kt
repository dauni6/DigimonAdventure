package com.dontsu.data.model.entity

import androidx.room.Entity
import com.dontsu.domain.model.Type
import javax.annotation.concurrent.Immutable

@Entity
@Immutable
data class TypeEntity(
    val id: Int?,
    val type: String?
) {
    fun mapper(): Type = Type(
        id = id,
        type = type
    )
}