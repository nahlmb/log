package space.nahlmb.log.data.source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import space.nahlmb.log.data.model.ToDoEntity

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo_table")
    fun getToDoList(): Flow<List<ToDoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToDoItem(item: ToDoEntity)

    @Update
    suspend fun updateToDoItem(item: ToDoEntity)

    @Delete
    suspend fun deleteToDoItem(item: ToDoEntity)
}