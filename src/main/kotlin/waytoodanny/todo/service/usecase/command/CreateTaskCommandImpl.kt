package waytoodanny.todo.service.usecase.command

import waytoodanny.todo.domain.Task
import waytoodanny.todo.service.persistence.TaskRepository
import waytoodanny.todo.usecase.CreateTaskCommand

class CreateTaskCommandImpl(private val taskRepository: TaskRepository) : CreateTaskCommand {

    override fun apply(task: Task): Task {
        return taskRepository.save(task)
    }
}