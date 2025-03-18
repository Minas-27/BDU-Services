package com.example.bduservices

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FavoriteRepository(context: Context) {
    private val favoriteDao = FavoriteDatabase.getDatabase(context).favoriteDao()

    fun getAllFavorites(): LiveData<List<Favorite>> {
        return favoriteDao.getAllFavorites()
    }

    suspend fun addFavorite(favorite: Favorite) {
        withContext(Dispatchers.IO) {
            favoriteDao.insert(favorite)
        }
    }

    suspend fun removeFavorite(favorite: Favorite) {
        withContext(Dispatchers.IO) {
            favoriteDao.delete(favorite)
        }
    }

    suspend fun isFavorite(serviceId: Int): Boolean {
        return withContext(Dispatchers.IO) {
            favoriteDao.getFavoriteById(serviceId) != null
        }
    }
}