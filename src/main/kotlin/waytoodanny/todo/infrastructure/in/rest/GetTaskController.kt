package waytoodanny.todo.infrastructure.`in`.rest

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import waytoodanny.todo.domain.Task
import waytoodanny.todo.usecase.TaskByIdQuery
import java.util.*

@RestController
class GetTaskController(private val taskByIdQuery: TaskByIdQuery) {

    @GetMapping("/task/{id}")
    fun allTasks(@PathVariable id: String): ResponseEntity<Task> =
            taskByIdQuery.task(UUID.fromString(id))
                    ?.let { t -> ResponseEntity.ok(t) }
                    ?: ResponseEntity.notFound().build()
}