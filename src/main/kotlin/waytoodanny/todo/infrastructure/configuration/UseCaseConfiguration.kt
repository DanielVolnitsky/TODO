package waytoodanny.todo.infrastructure.configuration

import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import waytoodanny.todo.infrastructure.out.jpa.JpaTaskRepository
import waytoodanny.todo.infrastructure.out.jpa.JpaTaskRepositoryAdapter
import waytoodanny.todo.service.command.CreateTaskCommandImpl
import waytoodanny.todo.usecase.CreateTaskCommand

@Configuration
class UseCaseConfiguration {

    @Bean
    fun createTaskCommand(jpaTaskRepository: JpaTaskRepository): CreateTaskCommand =
            CreateTaskCommandImpl(
                    JpaTaskRepositoryAdapter(
                            jpaTaskRepository,
                            Mappers.getMapper(JpaTaskRepositoryAdapter.TaskMapper::class.java)))
}