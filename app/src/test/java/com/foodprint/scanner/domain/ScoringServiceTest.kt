package com.foodprint.scanner.domain

import org.junit.Assert.assertEquals
import org.junit.Test

class ScoringServiceTest {
    @Test
    fun calculateScore_allNatural_returns100() {
        val items = listOf(
            ItemClassification("Apple", "Natural", 1.0f),
            ItemClassification("Banana", "Natural", 1.0f)
        )
        val score = ScoringService().calculateScore(items)
        assertEquals(100.0, score, 0.001)
    }

    @Test
    fun calculateScore_emptyList_returns0() {
        val score = ScoringService().calculateScore(emptyList())
        assertEquals(0.0, score, 0.001)
    }
}
