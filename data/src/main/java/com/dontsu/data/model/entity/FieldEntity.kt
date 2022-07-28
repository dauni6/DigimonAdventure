package com.dontsu.data.model.entity

import androidx.room.Entity
import com.dontsu.domain.model.Field
import javax.annotation.concurrent.Immutable

@Entity
@Immutable
data class FieldEntity(
    val `field`: String?,
    val id: Int?
) {
    fun mapper(): Field = Field(
        field = field,
        id = id
    )
}