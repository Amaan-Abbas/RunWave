package com.example.runWave.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Runs")
data class RunEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val distanceKm: Double,
    val durationSeconds: Long,
    val dateTimeStart: Long,
    val  avgPace: Double
)