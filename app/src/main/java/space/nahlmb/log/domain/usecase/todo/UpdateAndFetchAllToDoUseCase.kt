package space.nahlmb.log.domain.usecase.todo

import kotlinx.coroutines.flow.Flow
import space.nahlmb.log.domain.model.ToDoItem
import space.nahlmb.log.domain.repository.ToDoRepository

class UpdateAndFetchAllToDoUseCase(private val repository: ToDoRepository) {

    suspend operator fun invoke(item : ToDoItem) : Flow<List<ToDoItem>> {
        repository.updateToDoItem(item)
        return repository.getToDoList()
    }
}