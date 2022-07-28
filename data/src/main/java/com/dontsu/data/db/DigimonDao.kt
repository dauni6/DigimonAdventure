package com.dontsu.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dontsu.data.model.entity.DigimonEntity
import com.dontsu.data.model.entity.DigimonListEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DigimonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDigimonList(digimons: List<DigimonListEntity>)

    @Query("SELECT * FROM DigimonListEntity")
    fun getAllDigimon(): Flow<List<DigimonListEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDigimon(digimon: DigimonEntity)

    @Query("SELECT * FROM DigimonEntity")
    fun getDigimon(): Flow<DigimonEntity> // todo : use `distinctUntilChanged()`.

}
