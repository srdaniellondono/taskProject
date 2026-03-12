package com.example.taskProject.domain.ports.in;
import com.example.taskProject.domain.model.Task;
public interface CreateTaskUseCase {
    Task createTask (Task task);
}
