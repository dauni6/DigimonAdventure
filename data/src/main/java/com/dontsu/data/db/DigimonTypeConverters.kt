package com.dontsu.data.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dontsu.data.model.entity.*
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class AttributeListTypeConverter @Inject constructor(
    private val moshi: Moshi
) {

    @TypeConverter
    fun fromJson(value: String): List<AttributeEntity>? {
        val listType = Types.newParameterizedType(List::class.java, AttributeEntity::class.java)
        val adapter: JsonAdapter<List<AttributeEntity>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun toJson(type: List<AttributeEntity>): String {
        val listType = Types.newParameterizedType(List::class.java, AttributeEntity::class.java)
        val adapter: JsonAdapter<List<AttributeEntity>> = moshi.adapter(listType)
        return adapter.toJson(type)
    }

}

@ProvidedTypeConverter
class DescriptionListTypeConverter @Inject constructor(
    private val moshi: Moshi
) {

    @TypeConverter
    fun fromJson(value: String): List<DescriptionEntity>? {
        val listType = Types.newParameterizedType(List::class.java, DescriptionEntity::class.java)
        val adapter: JsonAdapter<List<DescriptionEntity>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    fun toJson(type: List<DescriptionEntity>): String {
        val listType = Types.newParameterizedType(List::class.java, DescriptionEntity::class.java)
        val adapter: JsonAdapter<List<DescriptionEntity>> = moshi.adapter(listType)
        return adapter.toJson(type)
    }
}

@ProvidedTypeConverter
class FieldListTypeConverter @Inject constructor(
    private val moshi: Moshi
) {

    @TypeConverter
    fun fromJson(value: String): List<FieldEntity>? {
        val listType = Types.newParameterizedType(List::class.java, FieldEntity::class.java)
        val adapter: JsonAdapter<List<FieldEntity>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun toJson(type: List<FieldEntity>): String {
        val listType = Types.newParameterizedType(List::class.java, FieldEntity::class.java)
        val adapter: JsonAdapter<List<FieldEntity>> = moshi.adapter(listType)
        return adapter.toJson(type)
    }

}

@ProvidedTypeConverter
class ImageListTypeConverter @Inject constructor(
    private val moshi: Moshi
) {

    @TypeConverter
    fun fromJson(value: String): List<ImageEntity>? {
        val listType = Types.newParameterizedType(List::class.java, ImageEntity::class.java)
        val adapter: JsonAdapter<List<ImageEntity>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun toJson(type: List<ImageEntity>): String {
        val listType = Types.newParameterizedType(List::class.java, ImageEntity::class.java)
        val adapter: JsonAdapter<List<ImageEntity>> = moshi.adapter(listType)
        return adapter.toJson(type)
    }

}

@ProvidedTypeConverter
class LevelListTypeConverter @Inject constructor(
  private val moshi: Moshi
) {

    @TypeConverter
    fun fromJson(value: String): List<LevelEntity>? {
        val listType = Types.newParameterizedType(List::class.java, LevelEntity::class.java)
        val adapter: JsonAdapter<List<LevelEntity>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun toJson(type: List<LevelEntity>): String {
        val listType = Types.newParameterizedType(List::class.java, LevelEntity::class.java)
        val adapter: JsonAdapter<List<LevelEntity>> = moshi.adapter(listType)
        return adapter.toJson(type)
    }

}

@ProvidedTypeConverter
class NextEvolutionListTypeConverter @Inject constructor(
    private val moshi: Moshi
) {

    @TypeConverter
    fun fromJson(value: String): List<NextEvolutionEntity>? {
        val listType = Types.newParameterizedType(List::class.java, NextEvolutionEntity::class.java)
        val adapter: JsonAdapter<List<NextEvolutionEntity>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun toJson(type: List<NextEvolutionEntity>): String {
        val listType = Types.newParameterizedType(List::class.java, NextEvolutionEntity::class.java)
        val adapter: JsonAdapter<List<NextEvolutionEntity>> = moshi.adapter(listType)
        return adapter.toJson(type)
    }

}

@ProvidedTypeConverter
class PriorEvolutionListTypeConverter @Inject constructor(
    private val moshi: Moshi
) {

    @TypeConverter
    fun fromJson(value: String): List<PriorEvolutionEntity>? {
        val listType = Types.newParameterizedType(List::class.java, PriorEvolutionEntity::class.java)
        val adapter: JsonAdapter<List<PriorEvolutionEntity>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun toJson(type: List<PriorEvolutionEntity>): String {
        val listType = Types.newParameterizedType(List::class.java, PriorEvolutionEntity::class.java)
        val adapter: JsonAdapter<List<PriorEvolutionEntity>> = moshi.adapter(listType)
        return adapter.toJson(type)
    }
}

@ProvidedTypeConverter
class SkillListTypeConverter @Inject constructor(
    private val moshi: Moshi
) {

    @TypeConverter
    fun fromJson(value: String): List<SkillEntity>? {
        val listType = Types.newParameterizedType(List::class.java, SkillEntity::class.java)
        val adapter: JsonAdapter<List<SkillEntity>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun toJson(type: List<SkillEntity>): String {
        val listType = Types.newParameterizedType(List::class.java, SkillEntity::class.java)
        val adapter: JsonAdapter<List<SkillEntity>> = moshi.adapter(listType)
        return adapter.toJson(type)
    }
}

@ProvidedTypeConverter
class TypeListTypeConverter @Inject constructor(
    private val moshi: Moshi
) {

    @TypeConverter
    fun fromJson(value: String): List<TypeEntity>? {
        val listType = Types.newParameterizedType(List::class.java, TypeEntity::class.java)
        val adapter: JsonAdapter<List<TypeEntity>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun toJson(type: List<TypeEntity>): String {
        val listType = Types.newParameterizedType(List::class.java, TypeEntity::class.java)
        val adapter: JsonAdapter<List<TypeEntity>> = moshi.adapter(listType)
        return adapter.toJson(type)
    }
}
