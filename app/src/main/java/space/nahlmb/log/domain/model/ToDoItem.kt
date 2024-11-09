package space.nahlmb.log.domain.model

data class ToDoItem(
    val id: Int = 0, // Kita boleh set ID auto-generate oleh Room nanti
    val title: String,
    val subtitle: String,
    val isDone: Boolean = false
)