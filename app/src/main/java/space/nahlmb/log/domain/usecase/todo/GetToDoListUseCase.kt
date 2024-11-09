package space.nahlmb.log.domain.usecase.todo

import kotlinx.coroutines.flow.Flow
import space.nahlmb.log.domain.model.ToDoItem
import space.nahlmb.log.domain.repository.ToDoRepository

class GetToDoListUseCase(private val repository: ToDoRepository) {
    operator fun invoke(): Flow<List<ToDoItem>> {
        return repository.getToDoList()
    }
}