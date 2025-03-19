package com.example.bduservices

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CategoryServicesScreen(
    categoryId: Int,
    onServiceSelected: (String) -> Unit,
    favoritesViewModel: FavoritesViewModel = viewModel(
        factory = FavoritesViewModelFactory(LocalContext.current)
    )
) {
    val category = ServiceData.categories.find { it.id == categoryId }

    if (category == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Category not found!")
        }
        return
    }

    var serviceSearchQuery by remember { mutableStateOf("") }
    // Collect the favorites StateFlow as a State object
    val favorites by favoritesViewModel.favorites.observeAsState(emptySet())

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(
            value = serviceSearchQuery,
            onValueChange = { serviceSearchQuery = it },
            placeholder = { Text("Search services...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        val filteredServices = category.services.filter {
            it.name.contains(serviceSearchQuery, ignoreCase = true)
        }

        if (filteredServices.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("No services found!")
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(filteredServices, key = { it.id }) { service ->
                    ServiceItem(
                        service = service,
                        onServiceSelected = onServiceSelected,
                        isFavorite = favorites.contains(service.id),
                        onFavoriteToggled = { favoritesViewModel.toggleFavorite(service.id) }
                    )
                }
            }
        }
    }
}

@Composable
private fun ServiceItem(
    service: Service,
    onServiceSelected: (String) -> Unit,
    isFavorite: Boolean,
    onFavoriteToggled: () -> Unit
) {
    var isCurrentlyFavorite by remember { mutableStateOf(isFavorite) }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onServiceSelected(service.name) },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(text = service.name, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Price: ${service.price} ብር", fontSize = 14.sp)
            }
            IconButton(
                onClick = {
                    isCurrentlyFavorite = !isCurrentlyFavorite
                    onFavoriteToggled()
                }
            ) {
                Icon(
                    imageVector = if (isCurrentlyFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = if (isCurrentlyFavorite) Color.Red else Color.Gray
                )
            }
        }
    }
}