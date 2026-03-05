package com.example.runWave.data.repository

import com.example.runWave.data.local.dao.RunDao
import com.example.runWave.data.local.entity.RunEntity

class RunRepositoryImpl(
    private val runDao: RunDao
) : RunRepository {
    override suspend fun insertRun(run: RunEntity) {
        runDao.insertRun(run)
    }

    override suspend fun deleteRun(run: RunEntity) {
        runDao.deleteRun(run)
    }

    override suspend fun getAllRun(): List<RunEntity> {
        return runDao.getAllRuns()
    }
}