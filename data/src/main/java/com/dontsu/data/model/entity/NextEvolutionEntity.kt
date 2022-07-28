package com.dontsu.data.model.entity

import androidx.room.Entity
import com.dontsu.domain.model.NextEvolution
import javax.annotation.concurrent.Immutable

@Entity
@Immutable
data class NextEvolutionEntity(
    val condition: String?,
    val digimon: String?,
    val id: Int?
) {
    fun mapper(): NextEvolution = NextEvolution(
        condition = condition,
        digimon = digimon,
        id = id
    )
}