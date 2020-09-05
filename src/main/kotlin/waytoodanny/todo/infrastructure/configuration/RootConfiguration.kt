package waytoodanny.todo.infrastructure.configuration

import org.mapstruct.factory.Mappers
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import waytoodanny.todo.infrastructure.out.jpa.JpaTaskRepository
import waytoodanny.todo.infrastructure.out.jpa.JpaTaskRepositoryAdapter
import waytoodanny.todo.service.persistence.TaskRepository
import waytoodanny.todo.service.usecase.command.CreateTaskCommandImpl
import waytoodanny.todo.service.usecase.query.AllTasksQueryImpl
import waytoodanny.todo.usecase.AllTasksQuery
import waytoodanny.todo.usecase.CreateTaskCommand

@Configuration
class RootConfiguration {

    @Bean
    fun taskRepository(jpaTaskRepository: JpaTaskRepository): TaskRepository =
            JpaTaskRepositoryAdapter(
                    jpaTaskRepository,
                    Mappers.getMapper(JpaTaskRepositoryAdapter.TaskMapper::class.java)
            )

    @Bean
    fun createTaskCommand(taskRepository: TaskRepository): CreateTaskCommand =
            CreateTaskCommandImpl(taskRepository)

    @Bean
    fun allTasksQuery(taskRepository: TaskRepository): AllTasksQuery = AllTasksQueryImpl(taskRepository)
}