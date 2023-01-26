package com.dontsu.digimonadventure.di

import android.content.Context
import androidx.room.Room
import com.dontsu.data.db.*
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun provideDigimonDatabase(
        @ApplicationContext context: Context,
        attributeListTypeConverter: AttributeListTypeConverter,
        descriptionListTypeConverter: DescriptionListTypeConverter,
        fieldListTypeConverter: FieldListTypeConverter,
        imageListTypeConverter: ImageListTypeConverter,
        levelListTypeConverter: LevelListTypeConverter,
        nextEvolutionListTypeConverter: NextEvolutionListTypeConverter,
        priorEvolutionListTypeConverter: PriorEvolutionListTypeConverter,
        skillListTypeConverter: SkillListTypeConverter,
        typeListTypeConverter: TypeListTypeConverter
    ): DigimonDatabase = Room
        .databaseBuilder(context, DigimonDatabase::class.java,"digimon.db")
        .fallbackToDestructiveMigration()
        .addTypeConverter(attributeListTypeConverter)
        .addTypeConverter(descriptionListTypeConverter)
        .addTypeConverter(fieldListTypeConverter)
        .addTypeConverter(imageListTypeConverter)
        .addTypeConverter(levelListTypeConverter)
        .addTypeConverter(nextEvolutionListTypeConverter)
        .addTypeConverter(priorEvolutionListTypeConverter)
        .addTypeConverter(skillListTypeConverter)
        .addTypeConverter(typeListTypeConverter)
        .build()

    @Provides
    @Singleton
    fun provideDigimonDao(
        digimonDatabase: DigimonDatabase
    ): DigimonDao = digimonDatabase.digimonDao()

    @Provides
    @Singleton
    fun provideAttributeListTypeConverter(moshi: Moshi): AttributeListTypeConverter = AttributeListTypeConverter(moshi)

    @Provides
    @Singleton
    fun provideDescriptionListTypeConverter(moshi: Moshi): DescriptionListTypeConverter = DescriptionListTypeConverter(moshi)

    @Provides
    @Singleton
    fun provideFieldListTypeConverter(moshi: Moshi): FieldListTypeConverter = FieldListTypeConverter(moshi)

    @Provides
    @Singleton
    fun provideImageListTypeConverter(moshi: Moshi): ImageListTypeConverter = ImageListTypeConverter(moshi)

    @Provides
    @Singleton
    fun provideLevelListTypeConverter(moshi: Moshi): LevelListTypeConverter = LevelListTypeConverter(moshi)

    @Provides
    @Singleton
    fun provideNextEvolutionListTypeConverter(moshi: Moshi): NextEvolutionListTypeConverter =
        NextEvolutionListTypeConverter(moshi)

    @Provides
    @Singleton
    fun providePriorEvolutionListTypeConverter(moshi: Moshi): PriorEvolutionListTypeConverter =
        PriorEvolutionListTypeConverter(moshi)

    @Provides
    @Singleton
    fun provideSkillListListTypeConverter(moshi: Moshi): SkillListTypeConverter = SkillListTypeConverter(moshi)

    @Provides
    @Singleton
    fun provideTypeListTypeConver(moshi: Moshi): TypeListTypeConverter = TypeListTypeConverter(moshi)

}
