package space.nahlmb.log.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import space.nahlmb.log.core.base.ViewModelBaseImpl
import space.nahlmb.log.domain.model.ToDoItem
import space.nahlmb.log.domain.usecase.todo.GetToDoListUseCase
import space.nahlmb.log.domain.usecase.todo.InsertToDoItemUseCase
import space.nahlmb.log.domain.usecase.todo.UpdateAndFetchAllToDoUseCase

interface ToDoViewModel {
    val toDoList: StateFlow<List<ToDoItem>>
    fun fetchToDoList()
    fun addToDoItem(item: ToDoItem)
    fun updateAndRefresh(item: ToDoItem)
}