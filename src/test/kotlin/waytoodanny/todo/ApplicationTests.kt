package waytoodanny.todo

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest
@Testcontainers
class ApplicationTests {

    @Test
    fun contextLoads() {

    }

    companion object {

        @Container
        val container = PostgreSQLContainer<Nothing>("postgres:11").apply {
            withDatabaseName("todo")
            withUsername("todo-root")
            withPassword("todo-root")
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", container::getJdbcUrl)
            registry.add("spring.datasource.password", container::getPassword)
            registry.add("spring.datasource.username", container::getUsername)

            registry.add("spring.liquibase.url", container::getJdbcUrl)
        }
    }
}
