package com.dontsu.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dontsu.data.model.entity.ContentEntity
import com.dontsu.data.model.entity.DigimonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DigimonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDigimonList(digimons: List<ContentEntity>)

    @Query("SELECT * FROM ContentEntity")
    fun getAllDigimon(): Flow<List<ContentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDigimon(digimon: DigimonEntity)

    @Query("SELECT * FROM DigimonEntity WHERE id = :id")
    fun getDigimon(id: Int): DigimonEntity? // todo : use `distinctUntilChanged()`.

}
