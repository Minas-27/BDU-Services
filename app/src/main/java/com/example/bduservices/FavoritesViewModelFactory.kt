package com.example.bduservices

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class FavoritesViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoritesViewModel::class.java)) {
            val application = context.applicationContext as Application // Get the Application instance
            return FavoritesViewModel(application) as T // Pass the Application instance
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}