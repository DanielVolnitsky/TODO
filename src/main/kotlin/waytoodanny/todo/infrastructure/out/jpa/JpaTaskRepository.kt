package waytoodanny.todo.infrastructure.out.jpa

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import waytoodanny.todo.infrastructure.out.jpa.entity.TaskEntity
import java.util.*

@Repository
interface JpaTaskRepository : CrudRepository<TaskEntity, UUID>