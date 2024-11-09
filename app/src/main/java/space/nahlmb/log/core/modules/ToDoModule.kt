package space.nahlmb.log.core.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import space.nahlmb.log.data.repository.ToDoRepositoryImpl
import space.nahlmb.log.domain.repository.ToDoRepository
import space.nahlmb.log.domain.usecase.todo.GetToDoListUseCase
import space.nahlmb.log.domain.usecase.todo.InsertToDoItemUseCase
import space.nahlmb.log.domain.usecase.todo.UpdateAndFetchAllToDoUseCase
import org.koin.dsl.module
import space.nahlmb.log.presentation.viewmodel.ToDoViewModel
import space.nahlmb.log.presentation.viewmodel.ToDoViewModelImpl


val toDoModule = module {
    single<ToDoRepository> { ToDoRepositoryImpl(get()) }
    single { GetToDoListUseCase(get()) }
    single { InsertToDoItemUseCase(get()) }
    single { UpdateAndFetchAllToDoUseCase(get()) }
    viewModel<ToDoViewModelImpl> { ToDoViewModelImpl(get(), get(), get()) }
}