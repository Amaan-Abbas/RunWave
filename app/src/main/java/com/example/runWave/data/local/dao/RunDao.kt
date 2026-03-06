package com.example.runWave.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.runWave.data.local.entity.RunEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RunDao {

    @Insert
    suspend fun insertRun(run: RunEntity)

    @Delete
    suspend fun deleteRun(run: RunEntity)

    @Query("SELECT * FROM Runs ORDER BY dateTimeStart DESC")
    fun getAllRuns(): Flow<List<RunEntity>>
}