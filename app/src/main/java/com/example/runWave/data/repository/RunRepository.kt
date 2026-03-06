package com.example.runWave.data.repository

import com.example.runWave.data.local.entity.RunEntity
import kotlinx.coroutines.flow.Flow

interface RunRepository {
    suspend fun insertRun(run: RunEntity)
    suspend fun deleteRun(run: RunEntity)
    fun getAllRun(): Flow<List<RunEntity>>
}