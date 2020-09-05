package waytoodanny.todo.service.persistence

import waytoodanny.todo.domain.Task

interface TaskRepository {
    fun save(task: Task): Task

    fun allTasks(): Set<Task>;
}