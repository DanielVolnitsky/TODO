package waytoodanny.todo.infrastructure.rest

import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import waytoodanny.todo.domain.Task
import waytoodanny.todo.usecase.TaskByIdQuery
import java.util.*

@RestController
class GetTaskController(private val taskByIdQuery: TaskByIdQuery) {

    private val log = KotlinLogging.logger {}

    @GetMapping("/task/{id}")
    fun task(@PathVariable id: String): ResponseEntity<Task> {
        log.info { "Received 'get task' request by id - $id" }

        return taskByIdQuery.task(UUID.fromString(id))
                ?.let { t -> ResponseEntity.ok(t) }
                ?: ResponseEntity.notFound().build()
    }
}