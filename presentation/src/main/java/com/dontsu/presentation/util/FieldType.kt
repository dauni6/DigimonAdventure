package com.dontsu.presentation.util

import androidx.annotation.DrawableRes
import com.dontsu.presentation.R

enum class FieldType(
    val id: Int,
    @DrawableRes val fieldRes: Int,
    val fieldName: String
) {
    NATURE_SPIRITS(
        id = 1,
        fieldRes = R.drawable.nature_spirits,
        fieldName = "Nature Spirits"
    ),
    VIRUS_BUSTERS(
        id = 2,
        fieldRes = R.drawable.virus_busters,
        fieldName = "Virus Busters"
    ),
    WIND_GUARDIANS(
        id = 3,
        fieldRes = R.drawable.wind_guardians,
        fieldName = "Wind Guardians"
    ),
    UNKNOWN(
        id = 4,
        fieldRes = R.drawable.unknown,
        fieldName = "Unknown"
    ),
    METAL_EMPIRE(
        id = 5,
        fieldRes = R.drawable.metal_empire,
        fieldName = "Metal Empire"
    ),
    DEEP_SAVERS(
        id = 6,
        fieldRes = R.drawable.deep_savers,
        fieldName = "Deep Savers"
    ),
    DARK_AREA(
        id = 7,
        fieldRes = R.drawable.dark_area,
        fieldName = "Dark Area"
    ),
    NIGHTMARE_SOLDIERS(
        id = 8,
        fieldRes = R.drawable.nightmare_soldiers,
        fieldName = "Nightmare Soldiers"
    ),
    DRAGONS_ROAR(
        id = 9,
        fieldRes = R.drawable.dragons_roar,
        fieldName = "Dragon's Roar"
    ),
    JUNGLE_TROOPERS(
        id = 10,
        fieldRes = R.drawable.jungle_troopers,
        fieldName = "Jungle Troopers"
    )
}

fun findResOrNull(id: Int?): Int? = when(id) {
    FieldType.NATURE_SPIRITS.id -> FieldType.NATURE_SPIRITS.fieldRes
    FieldType.VIRUS_BUSTERS.id -> FieldType.VIRUS_BUSTERS.fieldRes
    FieldType.WIND_GUARDIANS.id -> FieldType.WIND_GUARDIANS.fieldRes
    FieldType.UNKNOWN.id -> FieldType.UNKNOWN.fieldRes
    FieldType.METAL_EMPIRE.id -> FieldType.METAL_EMPIRE.fieldRes
    FieldType.DEEP_SAVERS.id -> FieldType.DEEP_SAVERS.fieldRes
    FieldType.DARK_AREA.id -> FieldType.DARK_AREA.fieldRes
    FieldType.NIGHTMARE_SOLDIERS.id -> FieldType.NIGHTMARE_SOLDIERS.fieldRes
    FieldType.DRAGONS_ROAR.id -> FieldType.DRAGONS_ROAR.fieldRes
    FieldType.JUNGLE_TROOPERS.id -> FieldType.JUNGLE_TROOPERS.fieldRes
    else -> null
}
