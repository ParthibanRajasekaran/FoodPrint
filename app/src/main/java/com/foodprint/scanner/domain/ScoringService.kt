package com.foodprint.scanner.domain

class ScoringService {
    fun calculateScore(items: List<ItemClassification>): Double {
        if (items.isEmpty()) return 0.0
        val natural = items.count { it.category.equals("Natural", ignoreCase = true) }
        val processed = items.count { it.category.equals("Processed", ignoreCase = true) }
        val ultraProcessed = items.count { it.category.equals("Ultra-Processed", ignoreCase = true) }
        val total = items.size
        return ((natural * 2 + processed * 1 + ultraProcessed * 0).toDouble() / total) * 100
    }
}
