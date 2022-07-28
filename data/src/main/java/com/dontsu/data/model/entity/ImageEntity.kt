package com.dontsu.data.model.entity

import androidx.room.Entity
import com.dontsu.domain.model.Image
import javax.annotation.concurrent.Immutable

@Entity
@Immutable
data class ImageEntity(
    val href: String?,
    val transparent: Boolean?
) {
    fun mapper(): Image = Image(
        href = href,
        transparent = transparent
    )
}