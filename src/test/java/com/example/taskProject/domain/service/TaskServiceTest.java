package com.example.taskProject.domain.service;

import com.example.taskProject.domain.model.Task;
import com.example.taskProject.domain.ports.out.TaskRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Telling JUnit we'll use Mockito
class TaskServiceTest {

    @Mock // 1. Create a Mock
    private TaskRepositoryPort taskRepositoryPort;

    @InjectMocks // 2. inject that mock in our real service
    private TaskService taskService;

    @Test
    void shouldCreateTaskSuccessfully() {
        // --- 1. ARRANGE ---
        // What the user send (without id or date)
        Task taskToCreate = new Task(null, "Aprender Mockito", "Realizar prueba unitaria", false, null);

        // What DB must return (with ID and simulated date)
        Task savedTask = new Task(1L, "Aprender Mockito", "Realizar prueba unitaria", false, LocalDateTime.now());

        // We teach the mock to respond: "When asked you tu save any task, return savedTask"
        when(taskRepositoryPort.save(any(Task.class))).thenReturn(savedTask);


        // --- 2. ACT ---
        Task result = taskService.createTask(taskToCreate);


        // --- 3. ASSERT ---
        assertNotNull(result, "La tarea devuelta no debería ser nula");
        assertEquals(1L, result.getId(), "El ID debería ser 1");
        assertEquals("Aprender Mockito", result.getTitle(), "El título debe coincidir");
        assertNotNull(result.getCreatedAt(), "La fecha de creación debió asignarse");

        // We validate that the service has called the “fake” database exactly once to save
        verify(taskRepositoryPort, times(1)).save(taskToCreate);
    }
}