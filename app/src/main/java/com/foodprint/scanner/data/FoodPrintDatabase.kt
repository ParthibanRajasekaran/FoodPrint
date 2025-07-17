package com.foodprint.scanner.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ReceiptEntity::class, FoodItemEntity::class], version = 1)
abstract class FoodPrintDatabase : RoomDatabase() {
    abstract fun receiptDao(): ReceiptDao
    abstract fun foodItemDao(): FoodItemDao
}

