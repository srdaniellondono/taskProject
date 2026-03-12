package com.example.taskProject.infrastructure.adapter.in.web.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TaskRequest {

    @NotBlank(message = "El título de la tarea es obligatorio y no puede quedar en blanco.")
    @Size(min = 3, max = 50, message = "El título debe tener entre 3 y 50 caracteres.")
    private String title;
    @Size(max = 500, message = "La descripción no puede superar los 500 caracteres")
    private String description;
}