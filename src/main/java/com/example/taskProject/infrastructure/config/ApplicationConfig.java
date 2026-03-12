package com.example.taskProject.infrastructure.config;
import com.example.taskProject.domain.service.TaskService;
import com.example.taskProject.domain.ports.out.TaskRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean // Le dice a Spring: "Toma este objeto y guárdalo en tu caja de herramientas (Contexto) para cuando un Controlador lo pida"
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort) {
        // Como el TaskPersistenceAdapter SÍ tiene @Component, Spring lo encuentra y lo inyecta aquí automáticamente
        return new TaskService(taskRepositoryPort);
    }
}