package com.foodprint.scanner.orchestrator

import com.foodprint.scanner.services.ClassificationService
import com.foodprint.scanner.services.OCRService
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.assertEquals

class ReceiptOrchestratorTest {
    @Test
    fun processReceipt_returnsClassifiedItems() = runBlocking {
        val orchestrator = ReceiptOrchestrator(OCRService(), ClassificationService())
        val result = orchestrator.processReceipt(listOf())
        assertEquals(3, result.size)
    }
}
