package waytoodanny.todo.service.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import waytoodanny.todo.service.CreateTaskImpl
import waytoodanny.todo.usecase.CreateTask

@Configuration
class UseCaseConfiguration {

    @Bean
    fun createTaskUseCase(): CreateTask = CreateTaskImpl()
}