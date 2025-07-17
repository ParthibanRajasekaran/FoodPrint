package com.foodprint.scanner.services

import com.foodprint.scanner.domain.ItemClassification
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ClassificationServiceTest {
    @Test
    fun `classify returns items with valid categories`() = runBlocking {
        val service = ClassificationService()
        val items = listOf("Apple", "Bread", "Soda")
        val result = service.classify(items)
        assertTrue(result.all { it.category in listOf("Natural", "Processed", "Ultra-Processed") })
    }
}

