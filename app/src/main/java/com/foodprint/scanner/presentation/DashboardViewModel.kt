package com.foodprint.scanner.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.foodprint.scanner.domain.ItemClassification
import com.foodprint.scanner.orchestrator.ReceiptOrchestrator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val orchestrator: ReceiptOrchestrator
) : ViewModel() {
    private val _items = MutableStateFlow<List<ItemClassification>>(emptyList())
    val items: StateFlow<List<ItemClassification>> = _items

    fun processDummyReceipt() {
        viewModelScope.launch {
            // Dummy: no real bitmaps, just trigger orchestrator
            val result = orchestrator.processReceipt(emptyList())
            _items.value = result
        }
    }
}

