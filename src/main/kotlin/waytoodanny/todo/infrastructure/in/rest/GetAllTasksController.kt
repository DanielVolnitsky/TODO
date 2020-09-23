package waytoodanny.todo.infrastructure.`in`.rest

import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import waytoodanny.todo.domain.Task
import waytoodanny.todo.usecase.AllTasksQuery

@RestController
class GetAllTasksController(val allTasksQuery: AllTasksQuery) {

    private val log = KotlinLogging.logger {}

    @GetMapping("/task")
    fun allTasks(): ResponseEntity<Set<Task>> {
        log.info { "Received 'get all tasks' request" }

        return ResponseEntity.ok(
                allTasksQuery.allTasks()
        )
    }
}