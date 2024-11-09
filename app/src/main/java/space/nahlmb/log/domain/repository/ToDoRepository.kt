package space.nahlmb.log.domain.repository
import kotlinx.coroutines.flow.Flow
import space.nahlmb.log.domain.model.ToDoItem

interface ToDoRepository {
    fun getToDoList(): Flow<List<ToDoItem>>
    suspend fun insertToDoItem(item: ToDoItem)
    suspend fun updateToDoItem(item: ToDoItem)
    suspend fun deleteToDoItem(item: ToDoItem)
}