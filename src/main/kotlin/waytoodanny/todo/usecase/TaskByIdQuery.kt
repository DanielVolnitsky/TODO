package waytoodanny.todo.usecase

import waytoodanny.todo.domain.Task
import java.util.*

interface TaskByIdQuery {
    fun task(id: UUID): Task?
}