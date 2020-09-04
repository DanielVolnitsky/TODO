package waytoodanny.todo.usecase

import waytoodanny.todo.domain.Task

interface CreateTaskCommand {
    fun apply(task: Task): Task
}