package com.example.taskProject.domain.ports.in;
import com.example.taskProject.domain.model.Task;
import java.util.List;
public interface RetrieveTaskUseCase {
    public Task findTaskById(Long id);
    public List<Task> getAllTasks();
}
