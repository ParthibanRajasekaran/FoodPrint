package com.foodprint.scanner.di

import android.content.Context
import androidx.room.Room
import com.foodprint.scanner.data.FoodPrintDatabase
import com.foodprint.scanner.services.OCRService
import com.foodprint.scanner.services.ClassificationService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): FoodPrintDatabase =
        Room.databaseBuilder(context, FoodPrintDatabase::class.java, "foodprint.db").build()

    @Provides
    fun provideReceiptDao(db: FoodPrintDatabase) = db.receiptDao()

    @Provides
    fun provideFoodItemDao(db: FoodPrintDatabase) = db.foodItemDao()

    @Provides
    @Singleton
    fun provideOCRService() = OCRService()

    @Provides
    @Singleton
    fun provideClassificationService() = ClassificationService()
}

