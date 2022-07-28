package com.dontsu.data.model.entity

import androidx.room.Entity
import com.dontsu.domain.model.Description
import javax.annotation.concurrent.Immutable

@Entity
@Immutable
data class DescriptionEntity(
    val description: String?,
    val language: String?,
    val origin: String?
) {
    fun mapper(): Description = Description(
        description = description,
        language = language,
        origin = origin
    )
}