package space.nahlmb.log.core.navigation

import android.util.Log
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import space.nahlmb.log.presentation.screen.todo.AddToDoScreen
import space.nahlmb.log.presentation.screen.todo.AddToDoScreenCallback
import space.nahlmb.log.presentation.screen.todo.ToDoScreen
import space.nahlmb.log.presentation.screen.todo.ToDoScreenCallback

fun NavGraphBuilder.toDoNavigation(navController: NavHostController) {
    // ListTodo Screen
    composable("log/todo") {
        // ListTodo Callback
        val toDoScreenCallback = object : ToDoScreenCallback {
            override fun onAddToDoItemClicked() {
                navController.navigate("log/todo/add")
            }
        }
        // ListTodo Compose Screen
        ToDoScreen(callback = toDoScreenCallback)
    }

    // Add ItemTodo Screen
    composable("log/todo/add") {

        // Add ItemTodo Callback
        val addToDoScreenCallback = object : AddToDoScreenCallback {
            override fun onSuccessAddToDo() {
                navController.popBackStack()
            }
        }

        Log.d("AddToDoScreenCallback", "iya ke add to do screen")

        // Add ItemTodo Compose Screen
        AddToDoScreen(callback = addToDoScreenCallback)
    }
}
