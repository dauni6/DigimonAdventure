package com.dontsu.data.model.entity

import androidx.room.Entity
import com.dontsu.domain.model.PriorEvolution
import javax.annotation.concurrent.Immutable

@Entity
@Immutable
data class PriorEvolutionEntity(
    val condition: String?,
    val digimon: String?,
    val id: Int?
) {
    fun mapper(): PriorEvolution = PriorEvolution(
        condition = condition,
        digimon = digimon,
        id = id
    )
}