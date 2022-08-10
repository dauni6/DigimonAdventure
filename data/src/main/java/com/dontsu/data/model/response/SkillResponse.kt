package com.dontsu.data.model.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import javax.annotation.concurrent.Immutable

@Immutable
@JsonClass(generateAdapter = true)
data class SkillResponse(
    @field:Json(name = "description")
    val description: String?,
    @field:Json(name = "id")
    val id: Int?,
    @field:Json(name = "skill")
    val skill: String?,
    @field:Json(name = "translation")
    val translation: String?
)
