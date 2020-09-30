package waytoodanny.todo.service

import waytoodanny.todo.domain.Task
import waytoodanny.todo.service.persistence.TaskRepository
import waytoodanny.todo.usecase.TaskByIdQuery
import java.util.*

class TaskByIdQueryImpl(private val taskRepository: TaskRepository) : TaskByIdQuery {

    override fun task(id: UUID): Task? = taskRepository.taskWithId(id)
}