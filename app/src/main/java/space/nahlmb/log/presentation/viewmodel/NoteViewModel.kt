package space.nahlmb.log.presentation.viewmodel

import kotlinx.coroutines.flow.StateFlow
import space.nahlmb.log.domain.model.NoteItem

interface NoteViewModel {
    val notes: StateFlow<List<NoteItem>>
    fun fetchNotes()
    fun addNote(note: NoteItem)
    fun updateNote(note: NoteItem)
    fun deleteNote(note: NoteItem)
}