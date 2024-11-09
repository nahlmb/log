package space.nahlmb.log.domain.repository
import kotlinx.coroutines.flow.Flow
import space.nahlmb.log.domain.model.NoteItem

interface NoteRepository {
    suspend fun insertNote(note: NoteItem)
    suspend fun updateNote(note: NoteItem)
    suspend fun deleteNote(noteId: Int)
    fun getAllNotes(): Flow<List<NoteItem>>
    suspend fun getNoteById(noteId: Int): NoteItem?
}