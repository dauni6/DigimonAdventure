package com.dontsu.data.mapper

import com.dontsu.data.model.entity.SkillEntity
import com.dontsu.data.model.reponse.SkillResponse
import com.dontsu.domain.model.Skill

fun toSkill(skill: SkillEntity?): Skill = Skill(
    description = skill?.description,
    id = skill?.id,
    skill = skill?.skill,
    translation = skill?.translation
)

fun toSkill(skill: SkillResponse?): Skill = Skill(
    description = skill?.description,
    id = skill?.id,
    skill = skill?.skill,
    translation = skill?.translation
)

fun toSkillEntity(skill: Skill): SkillEntity = SkillEntity(
    description = skill.description,
    id = skill.id,
    skill = skill.skill,
    translation = skill.translation
)
