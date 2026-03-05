package com.example.runWave.data.repository

import com.example.runWave.data.local.entity.RunEntity

interface RunRepository {
    suspend fun insertRun(run: RunEntity)
    suspend fun deleteRun(run: RunEntity)
    suspend fun getAllRun(): List<RunEntity>
}