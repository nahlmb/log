package space.nahlmb.log.presentation.screen.note

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import space.nahlmb.log.domain.model.NoteItem
import space.nahlmb.log.presentation.viewmodel.NoteViewModelImpl
import java.util.Date

@Composable
fun AddNoteScreen(viewModel : NoteViewModelImpl = koinViewModel()) {
    val notes by viewModel.notes.collectAsState()
    var noteTitle by remember { mutableStateOf("") }
    var noteText by remember { mutableStateOf("") }

    Scaffold {
        padding ->
        Column(modifier = Modifier.padding(padding)
            .padding(vertical = 16.dp)) {
            // Judul
            Text(text = "Daftar Catatan")

            // Daftar Catatan
            LazyColumn {
                items(notes) { note ->
                    NoteCard(note)
                }
            }

            // Field untuk menambah catatan
            TextField(
                value = noteTitle,
                onValueChange = { noteTitle = it },
                label = { Text("Tambah Catatan") },
                modifier = Modifier.fillMaxWidth()
            )

            TextField(
                value = noteText,
                onValueChange = { noteText = it },
                label = { Text("Tambah Catatan") },
                modifier = Modifier.fillMaxWidth()
            )

            // Tombol Simpan
            Button(
                onClick = {
                    if (noteTitle.isNotBlank() && noteText.isNotBlank()) {
                        viewModel.addNote(NoteItem(
                            title = noteTitle,
                            noteText =noteText,
                            createdAt = Date()
                        ))
                        // Reset field setelah simpan
                        noteTitle = ""
                        noteText = ""
                    }
                },
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(text = "Simpan")
            }
        }
    }
}