package com.example.runWave.presenter

import com.example.runWave.data.local.entity.RunEntity
import com.example.runWave.data.repository.RunRepository
import kotlinx.coroutines.flow.Flow

class RunPresenter(
    private val runRepository: RunRepository
) {
    suspend fun addRun(run: RunEntity) = runRepository.insertRun(run)
    suspend fun removeRun(run: RunEntity) = runRepository.deleteRun(run)
    fun getRun(): Flow<List<RunEntity>> = runRepository.getAllRun()
}