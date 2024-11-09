package space.nahlmb.log.domain.model

import java.util.Date

data class NoteItem(
    val id: Int = 0,
    val title: String,
    val noteText: String,
    val createdAt: Date
)