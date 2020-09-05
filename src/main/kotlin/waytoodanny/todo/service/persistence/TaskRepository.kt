package waytoodanny.todo.service.persistence

import waytoodanny.todo.domain.Task
import java.util.*

interface TaskRepository {
    fun save(task: Task): Task

    fun allTasks(): Set<Task>

    fun taskWithId(id: UUID): Task?
}