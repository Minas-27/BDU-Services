package com.example.bduservices

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.livedata.observeAsState
import kotlin.math.roundToInt

@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel = viewModel(
        factory = FavoritesViewModelFactory(LocalContext.current)
    )
) {
    val allFavorites by viewModel.allFavorites.observeAsState(emptyList())

    if (allFavorites.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("No favorites yet!")
        }
    } else {
        val spacing = if (allFavorites.size > 5) 4.dp else 8.dp
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(spacing)
        ) {
            items(allFavorites, key = { it.serviceId }) { favorite ->
                FavoriteItem(favorite = favorite, viewModel = viewModel)
            }
        }
    }
}

@Composable
fun FavoriteItem(
    favorite: Favorite,
    viewModel: FavoritesViewModel
) {
    var offsetX by remember { mutableFloatStateOf(0f) }
    var itemWidth by remember { mutableStateOf(IntSize.Zero) }
    var itemHeight by remember { mutableStateOf(IntSize.Zero) }
    val maxOffset = -itemWidth.width.toFloat()
    val deleteThreshold = maxOffset / 2
    val animatedOffsetX by animateFloatAsState(
        targetValue = offsetX,
        label = "offsetXAnimation"
    )
    var isSwiping by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .onGloballyPositioned { itemWidth = it.size }
    ) {
        // Static Red Background (Only Visible When Swiping)
        if (isSwiping || offsetX < 0) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(with(LocalDensity.current) { itemHeight.height.toDp() })
                    .background(Color.Red)
                    .offset { IntOffset(itemWidth.width, 0) },
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Delete",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .scale(1.5f)
                )
            }
        }

        // Swipable Item
        Box(
            modifier = Modifier
                .offset { IntOffset(animatedOffsetX.roundToInt(), 0) }
                .fillMaxWidth()
                .onGloballyPositioned { itemHeight = it.size }
                .pointerInput(Unit) {
                    detectHorizontalDragGestures(
                        onDragStart = {
                            isSwiping = true
                        },
                        onDragEnd = {
                            isSwiping = false
                            if (offsetX <= deleteThreshold) {
                                viewModel.removeFavorite(favorite.serviceId)
                            }
                            offsetX = 0f
                        },
                        onHorizontalDrag = { change, dragAmount ->
                            change.consume()
                            offsetX = (offsetX + dragAmount).coerceIn(maxOffset, 0f)
                        }
                    )
                }
        ) {
            FavoriteItemContent(favorite = favorite, viewModel = viewModel)
        }
    }
}

@Composable
fun FavoriteItemContent(
    favorite: Favorite,
    viewModel: FavoritesViewModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = favorite.serviceName,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Price: ${favorite.servicePrice} ብር",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
            IconButton(onClick = { viewModel.removeFavorite(favorite.serviceId) }){
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Remove Favorite",
                    tint = Color.Gray
                )
            }
        }
    }
}