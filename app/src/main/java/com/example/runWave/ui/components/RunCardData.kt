package com.example.runWave.ui.components

/**
 * Data class representing the statistics displayed on the RunFlashCard.
 * This can be populated from a backend response.
 */
data class RunCardData(
    val weekRange: String = "14 Jul - 20 Jul",
    val totalDistance: String = "32.4",
    val totalDistanceUnit: String = "km",
    val goalDistance: String = "40 km",
    val goalPercentage: Float = 0.81f,
    val vsLastWeekPercent: String = "18%",
    val vsLastWeekValue: String = "+5.2 km",
    val isPaceIncreasing: Boolean = false, // true for ↑, false for ↓
    val runsCount: String = "5",
    val totalTime: String = "4h 12m",
    val totalCalories: String = "2,480",
    val averagePace: String = "6:12",
    val paceUnit: String = "min/km",
    val paceChange: String = "12s"
)
