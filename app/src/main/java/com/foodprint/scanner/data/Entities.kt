package com.foodprint.scanner.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "receipts")
data class ReceiptEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val timestamp: Long,
    val imageUri: String,
    val score: Int
)

@Entity(tableName = "food_items")
data class FoodItemEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val classification: String,
    val confidence: Float,
    val receiptId: Long
)

