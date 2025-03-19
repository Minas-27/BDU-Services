package com.example.bduservices

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorite(
    @PrimaryKey val serviceId: Int,
    val serviceName: String,
    val servicePrice: Int
)

