package space.nahlmb.log.core.modules

import androidx.room.Room
import org.koin.dsl.module
import space.nahlmb.log.core.constant.DATABASE_NAME
import space.nahlmb.log.data.source.LogDatabase

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(), // context dari koin
            LogDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
    single { get<LogDatabase>().noteDao() }
    single { get<LogDatabase>().toDoDao() }
}