package com.dontsu.data.db

import androidx.room.*
import com.dontsu.data.model.entity.ContentEntity
import com.dontsu.data.model.entity.DigimonEntity
import com.dontsu.data.model.entity.FavoriteEntity
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

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(favorite: FavoriteEntity)

    @Query("SELECT * FROM FavoriteEntity WHERE id = :id")
    fun getFavorite(id: Int): Flow<FavoriteEntity?> // todo : use `distinctUntilChanged`.

    @Delete
    suspend fun deleteFavorite(favorite: FavoriteEntity)

}
