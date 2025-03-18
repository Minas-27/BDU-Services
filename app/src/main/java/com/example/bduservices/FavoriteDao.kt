package com.example.bduservices

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favorite: Favorite)

    @Delete
    suspend fun delete(favorite: Favorite)

    @Query("SELECT * FROM Favorite")
    fun getAllFavorites(): LiveData<List<Favorite>>

    @Query("SELECT * FROM Favorite WHERE serviceId = :serviceId")
    suspend fun getFavoriteById(serviceId: Int): Favorite?
}