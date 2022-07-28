package com.dontsu.data.model.entity

import androidx.room.Entity
import com.dontsu.domain.model.Attribute
import javax.annotation.concurrent.Immutable

@Entity
@Immutable
data class AttributeEntity(
    val attribute: String?,
    val id: Int?
) {
    fun mapper(): Attribute = Attribute(
        attribute = attribute,
        id = id
    )
}