package waytoodanny.todo.usecase

import waytoodanny.todo.domain.Task

interface AllTasksQuery {
    fun allTasks(): Set<Task>
}