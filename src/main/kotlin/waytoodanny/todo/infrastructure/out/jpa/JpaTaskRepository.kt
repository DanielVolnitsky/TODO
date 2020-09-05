package waytoodanny.todo.infrastructure.out.jpa

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import waytoodanny.todo.infrastructure.out.jpa.entity.TaskEntity
import java.util.*

@Repository
interface JpaTaskRepository : JpaRepository<TaskEntity, UUID>