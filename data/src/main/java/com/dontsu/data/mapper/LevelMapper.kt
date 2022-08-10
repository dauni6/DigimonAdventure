package com.dontsu.data.mapper

import com.dontsu.data.model.entity.LevelEntity
import com.dontsu.data.model.response.LevelResponse
import com.dontsu.domain.model.Level

fun LevelEntity.toLevel(): Level = Level(
    id = id,
    level = level
)

fun LevelResponse.toLevel(): Level = Level(
    id = id,
    level = level
)

fun Level.toLevelEntity(): LevelEntity = LevelEntity(
    id = id,
    level = level
)
