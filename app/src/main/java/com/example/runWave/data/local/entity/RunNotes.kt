package com.example.runWave.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Notes",
    foreignKeys = [
        ForeignKey(
            entity = RunEntity::class,
            parentColumns = ["id"],
            childColumns = ["runId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
) data class RunNotes(
    @PrimaryKey(autoGenerate = true)
    val noteId: Int = 0,
    val runId: Int,
    val note: String? = null,
    val timeStamp: Long
)
