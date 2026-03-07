package com.example.runWave.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.runWave.data.local.entity.RunNotes
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Upsert
    suspend fun insertRunNote(note : RunNotes)

    @Delete
    suspend fun deleteRunNote(note : RunNotes)

    @Query("SELECT * FROM Notes WHERE runId = :id ORDER BY timeStamp DESC")
    fun getNote(id: Int) : Flow<List<RunNotes>>
}
