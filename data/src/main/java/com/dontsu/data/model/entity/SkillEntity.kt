package com.dontsu.data.model.entity

import androidx.room.Entity
import com.dontsu.domain.model.Skill
import javax.annotation.concurrent.Immutable

@Entity
@Immutable
data class SkillEntity(
    val description: String?,
    val id: Int?,
    val skill: String?,
    val translation: String?
) {
    fun mapper(): Skill = Skill(
        description = description,
        id = id,
        skill = skill,
        translation = translation
    )
}