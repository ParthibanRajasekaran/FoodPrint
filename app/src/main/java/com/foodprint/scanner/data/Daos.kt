package com.foodprint.scanner.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ReceiptDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(receipt: ReceiptEntity): Long

    @Query("SELECT * FROM receipts ORDER BY timestamp DESC")
    fun getAll(): Flow<List<ReceiptEntity>>
}

@Dao
interface FoodItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: FoodItemEntity)

    @Query("SELECT * FROM food_items WHERE receiptId = :receiptId")
    fun getByReceipt(receiptId: Long): Flow<List<FoodItemEntity>>
}

