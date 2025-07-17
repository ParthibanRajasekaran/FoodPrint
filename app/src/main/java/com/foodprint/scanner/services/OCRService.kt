package com.foodprint.scanner.services

import android.graphics.Bitmap
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OCRService @Inject constructor() {
    suspend fun extractItems(bitmaps: List<Bitmap>): List<String> {
        // Dummy implementation for now
        return listOf("Apple", "Bread", "Soda")
    }
}
