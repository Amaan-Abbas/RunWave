package com.example.runWave.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.runWave.data.local.entity.RunEntity

@Composable
fun RunItem(run: RunEntity) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Distance: ${run.distanceKm}")
        Text(text = "Duration: ${run.durationSeconds}")
        Text(text = "Avg Pace: ${run.avgPace}")
        Text(text = "Start time: ${run.dateTimeStart}")
    }
}