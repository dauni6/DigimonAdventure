package com.dontsu.data.model.reponse

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import javax.annotation.concurrent.Immutable

/**
 * Used for getting Digimon list.
 * */
@Immutable
@JsonClass(generateAdapter = true)
data class DigimonListResponse(
    @field:Json(name = "content")
    val content: List<ContentResponse?>?,
    @field:Json(name = "pageable")
    val pageable: PageableResponse? // Not used in this project.
)
