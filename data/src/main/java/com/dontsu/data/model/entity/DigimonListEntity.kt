package com.dontsu.data.model.entity

import androidx.room.Entity
import com.dontsu.domain.model.DigimonList
import javax.annotation.concurrent.Immutable

/**
 * Used for getting Digimon list from Room.
 * */
@Entity
@Immutable
data class DigimonListEntity(
    val content: List<ContentEntity?>?,
    val pageable: PageableEntity? // Not used in this project.
) {
    fun mapper(): DigimonList = DigimonList(
        content = content?.map { it?.mapper() },
        pageable = pageable?.mapper()
    )
}