package space.nahlmb.log.domain.usecase.note

import space.nahlmb.log.domain.model.NoteItem
import space.nahlmb.log.domain.repository.NoteRepository

class InsertNoteUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke(note: NoteItem) {
        repository.insertNote(note)
    }
}
