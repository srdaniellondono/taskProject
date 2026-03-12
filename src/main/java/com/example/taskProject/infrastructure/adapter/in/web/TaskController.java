package com.example.taskProject.infrastructure.adapter.in.web;

import com.example.taskProject.domain.model.Task;
import com.example.taskProject.domain.ports.in.CreateTaskUseCase;
import com.example.taskProject.domain.ports.in.DeleteTaskUseCase;
import com.example.taskProject.domain.ports.in.RetrieveTaskUseCase;
import com.example.taskProject.infrastructure.adapter.in.web.dto.TaskRequest;
import com.example.taskProject.infrastructure.adapter.in.web.dto.TaskResponse;
import com.example.taskProject.infrastructure.adapter.in.web.mapper.TaskRestMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/tasks")
@Tag(name="Tareas",description = "EndPoints para la gestión completa de tareas")
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final TaskRestMapper mapper;

    public TaskController(CreateTaskUseCase createTaskUseCase,
                          RetrieveTaskUseCase retrieveTaskUseCase,
                          DeleteTaskUseCase deleteTaskUseCase,
                          TaskRestMapper mapper) {
        this.createTaskUseCase = createTaskUseCase;
        this.retrieveTaskUseCase = retrieveTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    @Operation(summary = "Crear una nueva tarea",description = "Recibe el título, descripción y guarda la tarea en PostgreSQL.")
    @ApiResponse(responseCode = "201",description = "Tarea creada exitosamente")
    public ResponseEntity<TaskResponse> createTask(@Valid @RequestBody TaskRequest request) {
        Task taskToCreate = mapper.toDomain(request);
        Task createdTask = createTaskUseCase.createTask(taskToCreate);
        return new ResponseEntity<>(mapper.toResponse(createdTask), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Obtener todas las tareas",description = "Devuelve una lista completa de todas las tareas registradas.")
    @ApiResponse(responseCode = "200",description = "Lista de tareas consultada con éxito.")
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        List<TaskResponse> responses = retrieveTaskUseCase.getAllTasks().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar tarea por su ID",description = "Busca una tarea específica usando su identificador único.")
    @ApiResponse(responseCode = "200",description = "Tarea encontrada.")
    @ApiResponse(responseCode = "404",description = "Tarea no encontrada.")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable Long id) {
        Task task = retrieveTaskUseCase.findTaskById(id);
        if (task != null) {
            return new ResponseEntity<>(mapper.toResponse(task), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar tarea por su ID",description = "Borra permanentemente una tarea de la base de datos mediante su ID.")
    @ApiResponse(responseCode = "204",description = "Tarea eliminada correctamente.")
    @ApiResponse(responseCode = "404",description = "Tarea no existe.")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        boolean deleted = deleteTaskUseCase.deleteTask(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
    }
}