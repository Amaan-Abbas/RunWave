package com.example.runWave.data.repository

import com.example.runWave.data.local.dao.NoteDao
import com.example.runWave.data.local.entity.RunNotes
import kotlinx.coroutines.flow.Flow

class NotesRepositoryImpl(
    private val notesDao: NoteDao
) : NotesRepository {
    override suspend fun inputNotes(notes: RunNotes) {
        notesDao.insertRunNote(notes)
    }

    override suspend fun removeNotes(notes: RunNotes) {
        notesDao.deleteRunNote(notes)
    }

    override fun retrieveNotes(runId: Int): Flow<List<RunNotes>> {
        return notesDao.getNote(runId)
    }

}