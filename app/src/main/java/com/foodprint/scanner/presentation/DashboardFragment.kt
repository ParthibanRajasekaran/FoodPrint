package com.foodprint.scanner.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.foodprint.scanner.R
import com.foodprint.scanner.domain.ItemClassification
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardFragment : Fragment() {
    private val viewModel: DashboardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pieChart = view.findViewById<PieChart>(R.id.pieChart)
        val btnProcess = view.findViewById<View>(R.id.btnProcessDummy)

        btnProcess.setOnClickListener {
            viewModel.processDummyReceipt()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.items.collectLatest { items ->
                updatePieChart(pieChart, items)
            }
        }
    }

    private fun updatePieChart(pieChart: PieChart, items: List<ItemClassification>) {
        val categoryCounts = items.groupingBy { it.category }.eachCount()
        val entries = categoryCounts.map { PieEntry(it.value.toFloat(), it.key) }
        val dataSet = PieDataSet(entries, "Categories")
        dataSet.setColors(intArrayOf(R.color.green, R.color.orange, R.color.red), requireContext())
        val data = PieData(dataSet)
        pieChart.data = data
        pieChart.invalidate()
    }
}
