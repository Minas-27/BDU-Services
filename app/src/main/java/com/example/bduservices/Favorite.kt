package com.example.bduservices

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Favorite(
    @PrimaryKey val serviceId: Int, // serviceId is now the primary key
    val serviceName: String,
    val servicePrice: Int
)

