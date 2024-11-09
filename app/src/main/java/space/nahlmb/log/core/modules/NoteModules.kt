package space.nahlmb.log.core.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import space.nahlmb.log.data.repository.NoteRepositoryImpl
import space.nahlmb.log.domain.repository.NoteRepository
import space.nahlmb.log.domain.usecase.note.DeleteNoteUseCase
import space.nahlmb.log.domain.usecase.note.GetAllNotesUseCase
import space.nahlmb.log.domain.usecase.note.InsertNoteUseCase
import space.nahlmb.log.domain.usecase.note.UpdateNoteUseCase
import space.nahlmb.log.presentation.viewmodel.NoteViewModelImpl


val noteModule = module {
    single<NoteRepository> { NoteRepositoryImpl(get()) } // inject NoteDao dari DatabaseModule
    single { GetAllNotesUseCase(get()) }
    single { InsertNoteUseCase(get()) }
    single { UpdateNoteUseCase(get()) }
    single { DeleteNoteUseCase(get()) }
    viewModel<NoteViewModelImpl> { NoteViewModelImpl(get(), get(), get(), get()) }
}