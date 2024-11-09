package space.nahlmb.log.data.repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import space.nahlmb.log.data.model.ToDoEntity
import space.nahlmb.log.data.source.ToDoDao
import space.nahlmb.log.domain.model.ToDoItem
import space.nahlmb.log.domain.repository.ToDoRepository

class ToDoRepositoryImpl(private val dao: ToDoDao) : ToDoRepository {
    override fun getToDoList(): Flow<List<ToDoItem>> {
        return dao.getToDoList().map { entities ->
            entities.map { entity ->
                ToDoItem(
                    id = entity.id,
                    title = entity.title,
                    subtitle = entity.subtitle,
                    isDone = entity.isDone
                )
            }
        }
    }

    override suspend fun insertToDoItem(item: ToDoItem) {
        dao.insertToDoItem(
            ToDoEntity(
                id = item.id,
                title = item.title,
                subtitle = item.subtitle,
                isDone = item.isDone
            )
        )
    }

    override suspend fun updateToDoItem(item: ToDoItem) {
        dao.updateToDoItem(
            ToDoEntity(
                id = item.id,
                title = item.title,
                subtitle = item.subtitle,
                isDone = item.isDone
            )
        )
    }

    override suspend fun deleteToDoItem(item: ToDoItem) {
        dao.deleteToDoItem(
            ToDoEntity(
                id = item.id,
                title = item.title,
                subtitle = item.subtitle,
                isDone = item.isDone
            )
        )
    }
}