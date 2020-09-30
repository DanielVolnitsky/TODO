package waytoodanny.todo.service

import waytoodanny.todo.domain.Task
import waytoodanny.todo.service.persistence.TaskRepository
import waytoodanny.todo.usecase.AllTasksQuery

class AllTasksQueryImpl(private val taskRepository: TaskRepository) : AllTasksQuery {

    override fun allTasks(): Set<Task> = taskRepository.allTasks();
}