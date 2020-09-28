package waytoodanny.todo.infrastructure.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import waytoodanny.todo.infrastructure.jpa.entity.TaskEntity

@Repository
interface JpaTaskRepository : JpaRepository<TaskEntity, String>