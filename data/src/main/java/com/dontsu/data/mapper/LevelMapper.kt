package com.dontsu.data.mapper

import com.dontsu.data.model.entity.LevelEntity
import com.dontsu.data.model.reponse.LevelResponse
import com.dontsu.domain.model.Level

fun toLevel(level: LevelEntity?): Level = Level(
    id = level?.id,
    level = level?.level
)

fun toLevel(level: LevelResponse?): Level = Level(
    id = level?.id,
    level = level?.level
)

fun toLevelEntity(level: Level): LevelEntity = LevelEntity(
    id = level.id,
    level = level.level
)
