package waytoodanny.todo.domain

import java.util.*

data class Task(var id: UUID?, val description: String) {

    fun withId(id: UUID): Task = Task(id, this.description)
}