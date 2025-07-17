package com.foodprint.scanner.orchestrator

import android.graphics.Bitmap
import com.foodprint.scanner.services.OCRService
import com.foodprint.scanner.services.ClassificationService
import com.foodprint.scanner.domain.ItemClassification
import javax.inject.Inject

class ReceiptOrchestrator @Inject constructor(
    private val ocrService: OCRService,
    private val classificationService: ClassificationService
) {
    suspend fun processReceipt(bitmaps: List<Bitmap>): List<ItemClassification> {
        val items = ocrService.extractItems(bitmaps)
        return classificationService.classify(items)
    }
}
