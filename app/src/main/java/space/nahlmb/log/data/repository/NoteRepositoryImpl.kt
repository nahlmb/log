package space.nahlmb.log.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import space.nahlmb.log.data.model.NoteEntity
import space.nahlmb.log.data.source.NoteDao
import space.nahlmb.log.domain.model.NoteItem
import space.nahlmb.log.domain.repository.NoteRepository

class NoteRepositoryImpl(private val noteDao: NoteDao) : NoteRepository {

    override suspend fun insertNote(note: NoteItem) {
        noteDao.insertNote(note.toEntity())
    }

    override suspend fun updateNote(note: NoteItem) {
        noteDao.updateNote(note.toEntity())
    }

    override suspend fun deleteNote(noteId: Int) {
        noteDao.deleteNoteById(noteId)
    }

    override fun getAllNotes(): Flow<List<NoteItem>> {
        return noteDao.getAllNotes().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun getNoteById(noteId: Int): NoteItem? {
        return noteDao.getNoteById(noteId)?.toDomain()
    }

    // Extension function to convert NoteItem to NoteEntity
    private fun NoteItem.toEntity(): NoteEntity {
        return NoteEntity(
            id = this.id,
            title = this.title,
            noteText = this.noteText,
            createdAt = this.createdAt
        )
    }

    // Extension function to convert NoteEntity to NoteItem
    private fun NoteEntity.toDomain(): NoteItem {
        return NoteItem(
            id = this.id,
            title = this.title,
            noteText = this.noteText,
            createdAt = this.createdAt
        )
    }
}