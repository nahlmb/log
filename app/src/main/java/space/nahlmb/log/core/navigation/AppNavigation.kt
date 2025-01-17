package space.nahlmb.log.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "log") {
        homeNavigation(navController)
        toDoNavigation(navController)
        noteNavigation(navController)
    }
}