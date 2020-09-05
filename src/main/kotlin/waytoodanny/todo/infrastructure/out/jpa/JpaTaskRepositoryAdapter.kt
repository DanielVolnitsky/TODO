package waytoodanny.todo.infrastructure.out.jpa

import waytoodanny.todo.domain.Task
import waytoodanny.todo.infrastructure.out.jpa.entity.TaskEntity
import waytoodanny.todo.service.persistence.TaskRepository
import java.util.stream.Collectors.toSet

class JpaTaskRepositoryAdapter(
        private val jpaRepository: JpaTaskRepository,
        private val taskMapper: TaskMapper
) : TaskRepository {

    override fun save(task: Task): Task =
            taskMapper.entityToDomain(
                    jpaRepository.save(
                            taskMapper.domainToEntity(task)
                    )
            )

    override fun allTasks(): Set<Task> = jpaRepository.findAll()
            .stream()
            .map(taskMapper::entityToDomain)
            .collect(toSet())

    interface TaskMapper {
        fun entityToDomain(entity: TaskEntity): Task
        fun domainToEntity(domain: Task): TaskEntity
    }
}