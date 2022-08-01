package com.dontsu.data.mapper

import com.dontsu.data.model.entity.SkillEntity
import com.dontsu.data.model.reponse.SkillResponse
import com.dontsu.domain.model.Skill

fun SkillEntity.toSkill(): Skill = Skill(
    description = description,
    id = id,
    skill = skill,
    translation = translation
)

fun SkillResponse.toSkill(): Skill = Skill(
    description = description,
    id = id,
    skill = skill,
    translation = translation
)

fun Skill.toSkillEntity(): SkillEntity = SkillEntity(
    description = description,
    id = id,
    skill = skill,
    translation = translation
)
