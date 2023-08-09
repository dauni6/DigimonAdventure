package com.dontsu.digimonadventure.di

import android.content.Context
import androidx.room.Room
import com.dontsu.data.db.*
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
    fun provideAttributeListTypeConverter(): AttributeListTypeConverter = AttributeListTypeConverter()

    @Provides
    @Singleton
    fun provideDescriptionListTypeConverter(): DescriptionListTypeConverter = DescriptionListTypeConverter()

    @Provides
    @Singleton
    fun provideFieldListTypeConverter(): FieldListTypeConverter = FieldListTypeConverter()

    @Provides
    @Singleton
    fun provideImageListTypeConverter(): ImageListTypeConverter = ImageListTypeConverter()

    @Provides
    @Singleton
    fun provideLevelListTypeConverter(): LevelListTypeConverter = LevelListTypeConverter()

    @Provides
    @Singleton
    fun provideNextEvolutionListTypeConverter(): NextEvolutionListTypeConverter = NextEvolutionListTypeConverter()

    @Provides
    @Singleton
    fun providePriorEvolutionListTypeConverter(): PriorEvolutionListTypeConverter = PriorEvolutionListTypeConverter()

    @Provides
    @Singleton
    fun provideSkillListListTypeConverter(): SkillListTypeConverter = SkillListTypeConverter()

    @Provides
    @Singleton
    fun provideTypeListTypeConverter(): TypeListTypeConverter = TypeListTypeConverter()

}
