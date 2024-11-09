package space.nahlmb.log.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import space.nahlmb.log.core.theme.LogTheme


interface HomeScreenCallback {
    fun onToDoClicked()
    fun onNoteClicked()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(callback: HomeScreenCallback? = null) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Log;/") },
                actions = {
                })
        }
    ) {
            padding ->
        Column(modifier = Modifier.padding(padding).fillMaxWidth().padding(horizontal = LogTheme.PADDING_LARGE.dp)) {
            Text("Selamat datang di Log App!")
            Text("Silakan pilih menu")

            Spacer(modifier = Modifier.height(16.dp))

            // add two button below, for to-do and for note
            Row(modifier = Modifier.fillMaxWidth()) {
                Button(modifier = Modifier.weight(1f), content = { Text("To-Do") },onClick = {
                    callback?.onToDoClicked()
                })
                Spacer(modifier = Modifier.width(LogTheme.PADDING_SMALL.dp))
                Button(modifier = Modifier.weight(1f), content = { Text("Note") },onClick = {
                    callback?.onNoteClicked()
                })
            }


        }
    }
}