package waytoodanny.todo.infrastructure.out.jpa

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import waytoodanny.todo.infrastructure.out.jpa.entity.TaskEntity

@ExtendWith(SpringExtension::class)
@DataJpaTest
class JpaTaskRepositoryIntegrationTest(@Autowired val sut: JpaTaskRepository) {

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