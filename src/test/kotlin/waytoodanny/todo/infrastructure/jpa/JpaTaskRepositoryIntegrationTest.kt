package waytoodanny.todo.infrastructure.jpa

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import waytoodanny.todo.CommonIntegrationTest
import waytoodanny.todo.infrastructure.jpa.entity.TaskEntity

class JpaTaskRepositoryIntegrationTest(@Autowired val sut: JpaTaskRepository) : CommonIntegrationTest() {

    @Test
    fun `when save then assert entity is fetched with generated id`() {
        val description = "description"

        val saved: TaskEntity = sut.save(
                TaskEntity(null, description)
        )
        assertThat(saved.id).isNotNull()

        val fetched: TaskEntity = sut.getOne(saved.id!!)
        assertThat(fetched).isNotNull
        assertThat(fetched.id).isEqualTo(saved.id)
        assertThat(fetched.description).isEqualTo(description)
    }
}