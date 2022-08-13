package com.coderz.f1.composenotes.feature_note.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.coderz.f1.composenotes.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Database(entities = [Note::class],version = 1)
abstract class NoteDatabase:RoomDatabase() {
    abstract val noteDao:NoteDao
    companion object{
        const val DATABASE_NAME="notes_db"
    }
}