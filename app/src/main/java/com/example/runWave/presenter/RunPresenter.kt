package com.example.runWave.presenter

import com.example.runWave.data.local.entity.RunEntity
import com.example.runWave.data.repository.RunRepository

class RunPresenter(
    private val runRepository: RunRepository
) {
    suspend fun addRun(run: RunEntity) = runRepository.insertRun(run)
    suspend fun removeRun(run: RunEntity) = runRepository.deleteRun(run)
    suspend fun getRun(): List<RunEntity> = runRepository.getAllRun()
}