package com.example.taskProject.infrastructure.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Task Management API - Portafolio",
                version = "1.0",
                description = "API RESTful para la gestión de tareas construida aplicando Arquitectura Hexagonal, Spring Boot y PostgreSQL.",
                contact = @Contact(
                        name = "Daniel Londoño (Backend Developer)",
                        email = "danielbellanita@gmail.com",
                        url = "https://linkedin.com/in/danielbellanita"
                )
        )
)
public class OpenApiConfig { }