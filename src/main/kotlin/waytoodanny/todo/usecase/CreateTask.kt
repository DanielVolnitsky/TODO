package waytoodanny.todo.usecase

import waytoodanny.todo.domain.Task

interface CreateTask {
    fun apply(task: Task): Task
}