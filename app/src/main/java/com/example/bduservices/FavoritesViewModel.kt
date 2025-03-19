package com.example.bduservices

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {
    private val favoriteRepository = FavoriteRepository(application)
    // Use allFavorites to track favorites
    val allFavorites: LiveData<List<Favorite>> = favoriteRepository.getAllFavorites()

    // Create a derived LiveData for the set of favorite IDs
    private val _favorites = MutableLiveData<Set<Int>>(emptySet())
    val favorites: LiveData<Set<Int>> = _favorites

    init {
        viewModelScope.launch {
            updateFavoritesSet()
        }
    }

    fun toggleFavorite(serviceId: Int) {
        viewModelScope.launch {
            val isCurrentlyFavorite = favoriteRepository.isFavorite(serviceId)
            if (isCurrentlyFavorite) {
                val favorite = allFavorites.value?.find { it.serviceId == serviceId }
                if (favorite != null) {
                    favoriteRepository.removeFavorite(favorite)
                }
            } else {
                val service = ServiceData.categories.flatMap { it.services }.find { it.id == serviceId }
                if (service != null) {
                    val newFavorite = Favorite(service.id, service.name, service.price)
                    favoriteRepository.addFavorite(newFavorite)
                }
            }
            updateFavoritesSet()
        }
    }

    fun removeFavorite(serviceId: Int) {
        viewModelScope.launch {
            favoriteRepository.removeFavoriteById(serviceId)
            updateFavoritesSet()
        }
    }

    suspend fun getServiceName(serviceId: Int): String? {
        return favoriteRepository.getServiceName(serviceId)
    }

    private fun updateFavoritesSet() {
        val currentFavorites = allFavorites.value?.map { it.serviceId }?.toSet() ?: emptySet()
        _favorites.value = currentFavorites
    }
}