package com.foodprint.scanner.services

import com.foodprint.scanner.domain.ItemClassification
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class ClassificationService @Inject constructor() {
    private val categories = listOf("Natural", "Processed", "Ultra-Processed")
    suspend fun classify(items: List<String>): List<ItemClassification> {
        return items.map {
            val category = categories.random()
            val confidence = Random.nextFloat()
            ItemClassification(it, category, confidence)
        }
    }
}
