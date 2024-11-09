package space.nahlmb.log.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import space.nahlmb.log.core.constant.DATABASE_VERSION
import space.nahlmb.log.core.utils.RoomDateConverterUtil
import space.nahlmb.log.data.model.NoteEntity
import space.nahlmb.log.data.model.ToDoEntity

@Database(entities = [ToDoEntity::class, NoteEntity::class], version = DATABASE_VERSION, exportSchema = false)
@TypeConverters(RoomDateConverterUtil::class)
abstract class LogDatabase : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
    abstract fun noteDao(): NoteDao
}