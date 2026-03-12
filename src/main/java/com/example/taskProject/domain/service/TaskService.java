package com.example.taskProject.domain.service;

import com.example.taskProject.domain.exceptions.TaskNotFoundException;
import com.example.taskProject.domain.model.Task;
import com.example.taskProject.domain.ports.in.CreateTaskUseCase;
import com.example.taskProject.domain.ports.in.DeleteTaskUseCase;
import com.example.taskProject.domain.ports.in.RetrieveTaskUseCase;
import com.example.taskProject.domain.ports.out.TaskRepositoryPort;
import java.util.List;

public class TaskService implements CreateTaskUseCase, RetrieveTaskUseCase, DeleteTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    // Inyección de dependencias MANUAL (Sin @Autowired de Spring, esto es puro Java)
    public TaskService(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        if (task.getTitle() == null || task.getTitle().isEmpty()) {
            throw new IllegalArgumentException("El título de la tarea no puede estar vacío");
        }
        return taskRepositoryPort.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepositoryPort.findAll();
    }

    @Override
    public Task findTaskById(Long id){
        return taskRepositoryPort.findById(id).orElseThrow(()-> new TaskNotFoundException("No se logró encontrar la tarea con el id: "+id));
    }

    @Override
    public boolean deleteTask(Long id) {
        return taskRepositoryPort.deleteById(id);
    }

}