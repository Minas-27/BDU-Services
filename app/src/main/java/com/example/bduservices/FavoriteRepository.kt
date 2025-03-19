package com.example.bduservices

import android.content.Context
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import androidx.lifecycle.map

class FavoriteRepository(context: Context) {
    private val favoriteDao = FavoriteDatabase.getDatabase(context).favoriteDao()

    fun getAllFavorites(): LiveData<List<Favorite>> {
        return favoriteDao.getAllFavorites()
    }

    suspend fun addFavorite(favorite: Favorite) {
        withContext(Dispatchers.IO) {
            favoriteDao.insert(favorite)}
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
    suspend fun removeFavoriteById(serviceId: Int) {
        withContext(Dispatchers.IO) {
            val favorite = favoriteDao.getFavoriteById(serviceId)
            favorite?.let { favoriteDao.delete(it) }
        }
    }
    fun getFavoriteServices(): LiveData<List<Service>> {
        return favoriteDao.getAllFavorites().map { favorites ->
            favorites.map { favorite ->
                Service(
                    id = favorite.serviceId,
                    name = favorite.serviceName,
                    price = favorite.servicePrice
                )
            }
        }
    }
    suspend fun getServiceName(serviceId: Int): String? {
        return withContext(Dispatchers.IO) {
            val service = ServiceData.categories.flatMap { it.services }.find { it.id == serviceId }
            service?.name
        }
    }
}