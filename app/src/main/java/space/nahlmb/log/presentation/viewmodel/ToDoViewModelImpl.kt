package space.nahlmb.log.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import space.nahlmb.log.core.base.ViewModelBaseImpl
import space.nahlmb.log.domain.model.ToDoItem
import space.nahlmb.log.domain.usecase.todo.GetToDoListUseCase
import space.nahlmb.log.domain.usecase.todo.InsertToDoItemUseCase
import space.nahlmb.log.domain.usecase.todo.UpdateAndFetchAllToDoUseCase

class ToDoViewModelImpl(
    private val getToDoListUseCase: GetToDoListUseCase,
    private val insertToDoItemUseCase: InsertToDoItemUseCase,
    private val updateAndFetchAllToDoUseCase: UpdateAndFetchAllToDoUseCase
) : ViewModelBaseImpl(), ToDoViewModel {

    private val _toDoList = MutableStateFlow<List<ToDoItem>>(emptyList())
    override val toDoList: StateFlow<List<ToDoItem>> = _toDoList

    init {
        fetchToDoList()
    }

    override fun fetchToDoList() {
        viewModelScope.launch {
            getToDoListUseCase().collect { items ->
                _toDoList.value = items
            }
        }
    }

    override fun addToDoItem(item: ToDoItem) {
        viewModelScope.launch {
            insertToDoItemUseCase(item)
        }
    }

    override fun updateAndRefresh(item : ToDoItem) {
        viewModelScope.launch {
            updateAndFetchAllToDoUseCase(item).collect { updatedList ->
                _toDoList.value = updatedList // Memperbarui state
            }
        }
    }
}