package com.example.bduservices

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryListScreen(onCategorySelected: (Int) -> Unit) { // Now uses ID
    var searchQuery by remember { mutableStateOf("") }
    val categories = ServiceData.categories

    Column(modifier = Modifier.fillMaxSize()) {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search categories...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        val filteredCategories = categories.filter {
            it.name.contains(searchQuery, ignoreCase = true)
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(filteredCategories, key = { it.id }) { // Use ID as key
                CategoryItem(category = it, onCategorySelected = onCategorySelected)
            }
        }
    }
}

@Composable
private fun CategoryItem(
    category: Category,
    onCategorySelected: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onCategorySelected(category.id) }, // Pass ID
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = category.imageResId),
                contentDescription = category.name,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = category.name, fontSize = 18.sp)
        }
    }
}