package space.nahlmb.log.domain.usecase.note

import kotlinx.coroutines.flow.Flow
import space.nahlmb.log.domain.model.NoteItem
import space.nahlmb.log.domain.repository.NoteRepository


class GetAllNotesUseCase(private val repository: NoteRepository) {
    suspend operator fun invoke(): Flow<List<NoteItem>> {
        return repository.getAllNotes()
    }
}
