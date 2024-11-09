package space.nahlmb.log.presentation.screen.note

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import space.nahlmb.log.core.theme.LogTheme
import space.nahlmb.log.domain.model.NoteItem
import space.nahlmb.log.presentation.viewmodel.NoteViewModelImpl


@Composable
fun NoteScreen(viewModel: NoteViewModelImpl = koinViewModel(), callback: NoteScreenCallback? = null) {
    val notes by viewModel.notes.collectAsState()

    Scaffold {
        padding ->
        Text("")
        Column(modifier = Modifier.padding(padding).fillMaxWidth()) {

            LazyColumn(modifier = Modifier.weight(1f).padding(horizontal = LogTheme.PADDING_LARGE.dp)) {
                items(notes) { note ->
                    NoteCard(note)
                }
            }

            HorizontalDivider(color = LogTheme.COLOR_DROP, thickness = LogTheme.PADDING_UNO.dp)

            Button(modifier = Modifier.fillMaxWidth().padding(LogTheme.PADDING_LARGE.dp),onClick =  {
                callback?.onAddNoteItemClicked()
            }) {
                Text("Add Note")
            }
        }

    }
}

@Composable
fun NoteCard(note: NoteItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
    ) {
        Text(
            text = note.noteText,
            modifier = Modifier.padding(16.dp)
        )
    }
}


interface NoteScreenCallback {
    fun onAddNoteItemClicked()
}