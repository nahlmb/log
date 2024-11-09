package space.nahlmb.log.domain.usecase.todo

import space.nahlmb.log.domain.model.ToDoItem
import space.nahlmb.log.domain.repository.ToDoRepository

class InsertToDoItemUseCase(private val repository: ToDoRepository) {
    suspend operator fun invoke(item: ToDoItem) {
        repository.insertToDoItem(item)
    }
}