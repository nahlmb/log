package space.nahlmb.log.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import space.nahlmb.log.presentation.screen.note.AddNoteScreen
import space.nahlmb.log.presentation.screen.note.NoteScreen

fun NavGraphBuilder.noteNavigation(navController: NavHostController) {
    // Note Screen
    composable("log/note") {
        // Note Compose Screen
        NoteScreen()
    }

    // Add Note Screen
    composable("log/note/add") {
        // Add Note Compose Screen
        AddNoteScreen()
    }
}
