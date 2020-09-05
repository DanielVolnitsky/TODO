package waytoodanny.todo.infrastructure.`in`.rest

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import waytoodanny.todo.domain.Task
import waytoodanny.todo.usecase.AllTasksQuery

@RestController
class GetAllTasksController(val allTasksQuery: AllTasksQuery) {

    @GetMapping("/task")
    fun allTasks(): ResponseEntity<Set<Task>> =
            ResponseEntity.ok(
                    allTasksQuery.allTasks()
            )
}