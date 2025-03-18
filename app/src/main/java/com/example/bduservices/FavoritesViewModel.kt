package com.example.bduservices

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {
    private val favoriteDao = FavoriteDatabase.getDatabase(application).favoriteDao()
    val allFavorites: LiveData<List<Favorite>> = favoriteDao.getAllFavorites()
    private val _favorites = MutableLiveData<Set<Int>>(emptySet())
    val favorites: LiveData<Set<Int>> = _favorites

    fun toggleFavorite(serviceId: Int) {
        viewModelScope.launch {
            val favorite = allFavorites.value?.find { it.serviceId == serviceId }
            if (favorite != null) {
                favoriteDao.delete(favorite)
            } else {
                val newFavorite = Favorite(serviceId, "Service $serviceId", 100)
                favoriteDao.insert(newFavorite)
            }
            val currentFavorites = allFavorites.value?.map { it.serviceId }?.toSet() ?: emptySet()
            _favorites.value = currentFavorites
        }
    }
}