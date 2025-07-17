package com.foodprint.scanner.services

import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.assertEquals

class OCRServiceTest {
    @Test
    fun extractItems_returnsDummyItems() = runBlocking {
        val service = OCRService()
        val result = service.extractItems(listOf())
        assertEquals(listOf("Apple", "Bread", "Soda"), result)
    }
}
