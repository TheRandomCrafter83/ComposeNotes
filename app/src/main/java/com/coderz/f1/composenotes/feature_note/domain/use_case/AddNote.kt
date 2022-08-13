package com.coderz.f1.composenotes.feature_note.domain.use_case

import com.coderz.f1.composenotes.feature_note.domain.model.InvalidNoteException
import com.coderz.f1.composenotes.feature_note.domain.model.Note
import com.coderz.f1.composenotes.feature_note.domain.repository.NoteRepository

class AddNote(private val repository: NoteRepository) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note:Note){
        if(note.title.isBlank()){
            throw InvalidNoteException("Title cannot be empty.")
        }
        if (note.content.isBlank()){
            throw InvalidNoteException("Content cannot be empty")
        }
        repository.insertNote(note)
    }
}