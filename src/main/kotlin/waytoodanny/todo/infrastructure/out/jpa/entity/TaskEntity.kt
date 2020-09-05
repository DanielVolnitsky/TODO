package waytoodanny.todo.infrastructure.out.jpa.entity

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
@Table(name = "task")
data class TaskEntity(

        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        var id: String? = null,

        @Column(nullable = false)
        var description: String
) {
    constructor() : this(null, "")
}