package com.dontsu.data.mapper

import com.dontsu.data.model.entity.FavoriteEntity
import com.dontsu.domain.model.Favorite

fun FavoriteEntity.toFavorite(): Favorite = Favorite(id = id)

fun Favorite.toFavoriteEntity(): FavoriteEntity = FavoriteEntity(id = id)
