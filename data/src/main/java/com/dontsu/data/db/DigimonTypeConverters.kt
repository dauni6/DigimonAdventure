package com.dontsu.data.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dontsu.data.model.entity.AttributeEntity
import com.dontsu.data.model.entity.DescriptionEntity
import com.dontsu.data.model.entity.FieldEntity
import com.dontsu.data.model.entity.ImageEntity
import com.dontsu.data.model.entity.LevelEntity
import com.dontsu.data.model.entity.NextEvolutionEntity
import com.dontsu.data.model.entity.PriorEvolutionEntity
import com.dontsu.data.model.entity.SkillEntity
import com.dontsu.data.model.entity.TypeEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@ProvidedTypeConverter
class AttributeListTypeConverter {

    @TypeConverter
    fun fromJson(value: String): List<AttributeEntity>? {
        val json = Json { ignoreUnknownKeys = true }
        return json.decodeFromString(value)
    }

    @TypeConverter
    fun toJson(type: List<AttributeEntity>): String {
        return Json.encodeToString(type)
    }

}

@ProvidedTypeConverter
class DescriptionListTypeConverter {

    @TypeConverter
    fun fromJson(value: String): List<DescriptionEntity>? {
        val json = Json { ignoreUnknownKeys = true }
        return json.decodeFromString(value)
    }

    @TypeConverter
    fun toJson(type: List<DescriptionEntity>): String {
        return Json.encodeToString(type)
    }
}

@ProvidedTypeConverter
class FieldListTypeConverter {

    @TypeConverter
    fun fromJson(value: String): List<FieldEntity>? {
        val json = Json { ignoreUnknownKeys = true }
        return json.decodeFromString(value)
    }

    @TypeConverter
    fun toJson(type: List<FieldEntity>): String {
        return Json.encodeToString(type)
    }

}

@ProvidedTypeConverter
class ImageListTypeConverter {

    @TypeConverter
    fun fromJson(value: String): List<ImageEntity>? {
        val json = Json { ignoreUnknownKeys = true }
        return json.decodeFromString(value)
    }

    @TypeConverter
    fun toJson(type: List<ImageEntity>): String {
        return Json.encodeToString(type)
    }

}

@ProvidedTypeConverter
class LevelListTypeConverter {

    @TypeConverter
    fun fromJson(value: String): List<LevelEntity>? {
        val json = Json { ignoreUnknownKeys = true }
        return json.decodeFromString(value)
    }

    @TypeConverter
    fun toJson(type: List<LevelEntity>): String {
        return Json.encodeToString(type)
    }

}

@ProvidedTypeConverter
class NextEvolutionListTypeConverter {

    @TypeConverter
    fun fromJson(value: String): List<NextEvolutionEntity>? {
        val json = Json { ignoreUnknownKeys = true }
        return json.decodeFromString(value)
    }

    @TypeConverter
    fun toJson(type: List<NextEvolutionEntity>): String {
        return Json.encodeToString(type)
    }

}

@ProvidedTypeConverter
class PriorEvolutionListTypeConverter {

    @TypeConverter
    fun fromJson(value: String): List<PriorEvolutionEntity>? {
        val json = Json { ignoreUnknownKeys = true }
        return json.decodeFromString(value)
    }

    @TypeConverter
    fun toJson(type: List<PriorEvolutionEntity>): String {
        return Json.encodeToString(type)
    }
}

@ProvidedTypeConverter
class SkillListTypeConverter {

    @TypeConverter
    fun fromJson(value: String): List<SkillEntity>? {
        val json = Json { ignoreUnknownKeys = true }
        return json.decodeFromString(value)
    }

    @TypeConverter
    fun toJson(type: List<SkillEntity>): String {
        return Json.encodeToString(type)
    }
}

@ProvidedTypeConverter
class TypeListTypeConverter {

    @TypeConverter
    fun fromJson(value: String): List<TypeEntity>? {
        val json = Json { ignoreUnknownKeys = true }
        return json.decodeFromString(value)
    }

    @TypeConverter
    fun toJson(type: List<TypeEntity>): String {
        return Json.encodeToString(type)
    }
}

