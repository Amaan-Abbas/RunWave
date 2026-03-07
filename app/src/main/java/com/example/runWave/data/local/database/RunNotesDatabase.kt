package com.example.runWave.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.runWave.data.local.dao.NoteDao
import com.example.runWave.data.local.entity.RunNotes

@Database(
    entities = [RunNotes::class],
    version = 1,
    exportSchema = false
)
abstract class RunNotesDatabase : RoomDatabase() {
    abstract fun runNotesDao() : NoteDao

    companion object {

        @Volatile
        private var INSTANCE: RunNotesDatabase? = null

        fun getDatabase(context: Context): RunNotesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RunNotesDatabase::class.java,
                    "run_notes_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}