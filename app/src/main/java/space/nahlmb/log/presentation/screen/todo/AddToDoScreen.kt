package space.nahlmb.log.presentation.screen.todo
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import space.nahlmb.log.domain.model.ToDoItem
import space.nahlmb.log.presentation.viewmodel.ToDoViewModelImpl

@Composable
fun AddToDoScreen(viewModel: ToDoViewModelImpl = koinViewModel(), callback: AddToDoScreenCallback? = null) {
    val toDoList by viewModel.toDoList.collectAsState()

    // State untuk menyimpan input
    var title by remember { mutableStateOf("") }
    var subtitle by remember { mutableStateOf("") }
    var isDone by remember { mutableStateOf(false) }

    Scaffold {
        padding ->
        Column(modifier = Modifier.padding(padding)) {
            TextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("To-Do Title") },
                modifier = Modifier.fillMaxWidth()
            )

            // Input untuk subtitle
            TextField(
                value = subtitle,
                onValueChange = { subtitle = it },
                label = { Text("To-Do Subtitle") },
                modifier = Modifier.fillMaxWidth()
            )

            // Checkbox untuk isDone
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = isDone,
                    onCheckedChange = { isDone = it }
                )
                Text("Done")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                if (title.isNotBlank() && subtitle.isNotBlank()) {

                    // Tambahkan item ke daftar
                    val newItem = ToDoItem(title = title, subtitle = subtitle, isDone = isDone)
                    viewModel.addToDoItem(newItem)

                    // Reset input
                    title = ""
                    subtitle = ""
                    isDone = false
                }

            }) {
                Text("Add To-Do Item")
            }
        }

    }

}

interface AddToDoScreenCallback {
    fun onSuccessAddToDo()
}