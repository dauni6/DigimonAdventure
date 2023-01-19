package com.dontsu.domain.model

data class Digimon(
    val attribute: List<Attribute?>?,
    val description: List<Description?>?,
    val field: List<Field?>?,
    val id: Int?,
    val image: List<Image?>?,
    val level: List<Level?>?,
    val name: String?,
    val nextEvolution: List<NextEvolution?>?,
    val priorEvolution: List<PriorEvolution?>?,
    val releaseDate: String?,
    val skills: List<Skill?>?,
    val type: List<Type?>?,
    val xAntibody: Boolean?
)
