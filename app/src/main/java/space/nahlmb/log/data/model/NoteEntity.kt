package space.nahlmb.log.data.model
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "notes")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val noteText: String,
    val createdAt: Date = Date() // Secara default, diisi dengan waktu saat ini
)