package space.nahlmb.log.presentation.screen.todo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
import space.nahlmb.log.presentation.viewmodel.ToDoViewModelImpl


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoScreen(viewModel: ToDoViewModelImpl = koinViewModel(), callback: ToDoScreenCallback? = null) {
    val toDoList by viewModel.toDoList.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("To-Do List") },
                actions = {
                })
        }
    ) {
        padding ->
        Column(modifier = Modifier.padding(padding)) {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(toDoList) { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = item.title, modifier = Modifier.weight(1f))
                        Checkbox(
                            checked = item.isDone,
                            onCheckedChange = {
                                viewModel.updateAndRefresh(item.copy(isDone = it))
                            }
                        )
                    }
                }
            }
            Button(content = {
                Text("Add To-Do Item")
            }, onClick = {
                callback?.onAddToDoItemClicked()
            })
        }
    }
}

interface ToDoScreenCallback {
    fun onAddToDoItemClicked()
}