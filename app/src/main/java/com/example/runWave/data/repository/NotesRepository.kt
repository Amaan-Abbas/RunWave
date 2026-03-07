package com.example.runWave.data.repository

import com.example.runWave.data.local.entity.RunNotes
import kotlinx.coroutines.flow.Flow

interface NotesRepository {
    suspend fun inputNotes(notes: RunNotes)
    suspend fun removeNotes(notes: RunNotes)
    fun retrieveNotes(runId: Int): Flow<List<RunNotes>>
}