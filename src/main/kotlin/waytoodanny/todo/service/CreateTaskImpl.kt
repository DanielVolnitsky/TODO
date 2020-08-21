package waytoodanny.todo.service

import waytoodanny.todo.domain.Task
import waytoodanny.todo.usecase.CreateTask
import java.util.*

class CreateTaskImpl : CreateTask {

    //TODO("Not yet implemented")
    override fun apply(task: Task): Task {
        return task.withId(UUID.randomUUID())
    }
}