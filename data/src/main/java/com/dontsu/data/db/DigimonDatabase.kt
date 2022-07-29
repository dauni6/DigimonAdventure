package com.dontsu.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dontsu.data.model.entity.ContentEntity
import com.dontsu.data.model.entity.DigimonEntity

@Database(entities = [ContentEntity::class, DigimonEntity::class], version = 1, exportSchema = false)
@TypeConverters(
    value = [
        AttributeListTypeConverter::class,
        DescriptionListTypeConverter::class,
        FieldListTypeConverter::class,
        ImageListTypeConverter::class,
        LevelListTypeConverter::class,
        NextEvolutionListTypeConverter::class,
        PriorEvolutionListTypeConverter::class,
        SkillListTypeConverter::class,
        TypeListTypeConverter::class
    ]
)
abstract class DigimonDatabase: RoomDatabase() {
    abstract fun digimonDao(): DigimonDao
}
