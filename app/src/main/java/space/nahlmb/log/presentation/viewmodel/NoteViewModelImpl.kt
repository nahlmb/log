package space.nahlmb.log.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import space.nahlmb.log.core.base.ViewModelBaseImpl
import space.nahlmb.log.domain.model.NoteItem
import space.nahlmb.log.domain.usecase.note.DeleteNoteUseCase
import space.nahlmb.log.domain.usecase.note.GetAllNotesUseCase
import space.nahlmb.log.domain.usecase.note.InsertNoteUseCase
import space.nahlmb.log.domain.usecase.note.UpdateNoteUseCase

class NoteViewModelImpl(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val insertNoteUseCase: InsertNoteUseCase,
    private val updateNoteUseCase: UpdateNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModelBaseImpl(), NoteViewModel {

    private val _notes = MutableStateFlow<List<NoteItem>>(emptyList())
    override val notes: StateFlow<List<NoteItem>> = _notes

    init {
        fetchNotes()
    }

    override fun fetchNotes() {
        viewModelScope.launch() {
            getAllNotesUseCase().collect { noteList ->
                _notes.value = noteList
            }
        }
    }

    override fun addNote(note: NoteItem) {
        viewModelScope.launch {
            insertNoteUseCase(note)
            fetchNotes() // Refresh the list
        }
    }

    override fun updateNote(note: NoteItem) {
        viewModelScope.launch {
            updateNoteUseCase(note)
            fetchNotes()
        }
    }

    override fun deleteNote(note: NoteItem) {
        viewModelScope.launch {
            deleteNoteUseCase(note)
            fetchNotes()
        }
    }
}