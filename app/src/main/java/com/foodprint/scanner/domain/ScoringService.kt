package com.foodprint.scanner.domain

class ScoringService {
    fun calculateScore(items: List<ItemClassification>): Double {
        if (items.isEmpty()) return 0.0
        val natural = items.count { it.category.equals("Natural", ignoreCase = true) }
        val processed = items.count { it.category.equals("Processed", ignoreCase = true) }
        val ultraProcessed = items.count { it.category.equals("Ultra-Processed", ignoreCase = true) }
        val total = items.size
        // Maximum score per item is 2, so divide by (total * 2) to keep result in 0..100
        val weightedSum = natural * 2 + processed
        return (weightedSum.toDouble() / (total * 2)) * 100
    }
}
