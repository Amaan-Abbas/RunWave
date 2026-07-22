package com.example.runWave.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.automirrored.filled.DirectionsRun
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.runWave.ui.theme.CardBackground
import com.example.runWave.ui.theme.CardBorder
import com.example.runWave.ui.theme.RunYellow

@Composable
fun RunFlashCard(
    modifier: Modifier = Modifier,
    data: RunCardData = RunCardData() // Accept dynamic data model
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(260.dp) // Adjusted height for full content
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black,
            contentColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        border = BorderStroke(width = 1.dp, color = CardBorder.copy(0.3f)),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // --- HEADER SECTION ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Preserving the "This Week" pill as implemented
                Row(
                    modifier = Modifier
                        .height(36.dp)
                        .clip(CircleShape)
                        .background(color = CardBackground)
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.CalendarToday,
                        tint = RunYellow,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "Weekly Run",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = data.weekRange,
                            color = Color.White.copy(0.6f),
                            fontSize = 9.sp
                        )
                    }
                }

                // Comparison section on the right
                Column(horizontalAlignment = Alignment.End) {
                    Text(text = "vs Last Week", color = Color.Gray, fontSize = 10.sp)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.ArrowUpward,
                            contentDescription = null,
                            tint = RunYellow,
                            modifier = Modifier.size(14.dp)
                        )
                        Text(
                            text = data.vsLastWeekPercent,
                            color = RunYellow,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    }
                    Text(
                        text = "(${data.vsLastWeekValue})",
                        color = Color.Gray,
                        fontSize = 10.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // --- PRIMARY STATS SECTION ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = data.totalDistance,
                            fontSize = 42.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = data.totalDistanceUnit,
                            fontSize = 18.sp,
                            color = Color.White.copy(0.7f),
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                    }
                    Text(text = "Total Distance", color = Color.Gray, fontSize = 12.sp)
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Circular progress representation
                    Box(contentAlignment = Alignment.Center) {
                        CircularProgressIndicator(
                            progress = { data.goalPercentage },
                            modifier = Modifier.size(56.dp),
                            color = RunYellow,
                            strokeWidth = 6.dp,
                            trackColor = Color.DarkGray
                        )
                        Text(
                            text = "${(data.goalPercentage * 100).toInt()}%",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(text = "Weekly Goal", color = Color.Gray, fontSize = 10.sp)
                        Text(
                            text = data.goalDistance,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                    }
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .size(12.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))
            HorizontalDivider(color = Color.White.copy(0.2f), thickness = 0.5.dp)
            Spacer(modifier = Modifier.weight(0.5f))

            // --- BOTTOM STATS GRID ---
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(IntrinsicSize.Min),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                StatItem(
                    icon = Icons.AutoMirrored.Filled.DirectionsRun,
                    value = data.runsCount,
                    label = "Runs"
                )
                VerticalDivider(
                    color = Color.White.copy(0.2f),
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                StatItem(icon = Icons.Default.Timer, value = data.totalTime, label = "Time")
                VerticalDivider(
                    color = Color.White.copy(0.2f),
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                StatItem(
                    icon = Icons.Default.LocalFireDepartment,
                    value = data.totalCalories,
                    label = "kcal"
                )
                VerticalDivider(
                    color = Color.White.copy(0.2f),
                    modifier = Modifier.padding(vertical = 4.dp)
                )

                // Pace item with change indicator
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Default.Speed,
                        contentDescription = null,
                        tint = RunYellow,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(text = data.averagePace, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = data.paceUnit, color = Color.Gray, fontSize = 10.sp)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = if (data.isPaceIncreasing) Icons.Default.ArrowUpward else Icons.Default.ArrowDownward,
                            contentDescription = null,
                            tint = RunYellow,
                            modifier = Modifier.size(10.dp)
                        )
                        Text(text = data.paceChange, color = RunYellow, fontSize = 10.sp)
                    }
                }
            }
        }
    }
}

/**
 * Helper component for displaying a stat item in the bottom grid.
 */
@Composable
private fun StatItem(icon: ImageVector, value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = RunYellow,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = value, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(text = label, color = Color.Gray, fontSize = 10.sp)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1C1A17)
@Composable
private fun FlashCardPreview() {
    RunFlashCard(
        data = RunCardData(
            weekRange = "14 Jul - 20 Jul",
            totalDistance = "32.4",
            goalPercentage = 0.81f,
            goalDistance = "40 km"
        )
    )
}
