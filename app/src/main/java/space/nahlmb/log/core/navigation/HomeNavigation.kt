package space.nahlmb.log.core.navigation

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import space.nahlmb.log.presentation.screen.HomeScreen
import space.nahlmb.log.presentation.screen.HomeScreenCallback

fun NavGraphBuilder.homeNavigation(navController: NavHostController) {
    // Home Screen
    composable("log") {
        // Home Callback
        val homeCallback = object : HomeScreenCallback {
            override fun onToDoClicked() {
                navController.navigate("log/todo")
            }

            override fun onNoteClicked() {
                try {
                    navController.navigate("log/note")
                }catch(e: Exception) {
                    Log.d("loghomecallback", "ini kenapa?, masuk navigasi kok")
                }
            }
        }
        // Home Callback Screen
        HomeScreen(callback = homeCallback)
    }
}
