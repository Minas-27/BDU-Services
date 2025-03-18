package com.example.bduservices

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FavoritesScreen(favoritesViewModel: FavoritesViewModel) {
    val favorites by favoritesViewModel.allFavorites.observeAsState(emptyList())
    val favoriteServiceIds by favoritesViewModel.favorites.observeAsState(emptySet())

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        if (favorites.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No favorites yet!",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(favorites, key = { it.serviceId }) { favorite ->
                    FavoriteItem(
                        favorite = favorite,
                        onToggleFavorite = { favoritesViewModel.toggleFavorite(favorite.serviceId) }
                    )
                }
            }
        }
    }
}

@Composable
private fun FavoriteItem(
    favorite: Favorite,
    onToggleFavorite: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = favorite.serviceName, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Price: ${favorite.servicePrice} ብር", fontSize = 14.sp)
            IconButton(
                onClick = onToggleFavorite
            ) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Favorite"
                )
            }
        }
    }
}