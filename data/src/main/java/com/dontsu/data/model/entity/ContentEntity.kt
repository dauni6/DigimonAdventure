package com.dontsu.data.model.entity

import androidx.room.Entity
import com.dontsu.domain.model.Content
import javax.annotation.concurrent.Immutable

/**
 * Used for getting Digimon list from Room.
 * */
@Entity
@Immutable
data class ContentEntity(
    val href: String?,
    val id: Int?,
    val name: String?
) {
    fun mapper(): Content = Content(
        href = href,
        id = id,
        name = name
    )
}
