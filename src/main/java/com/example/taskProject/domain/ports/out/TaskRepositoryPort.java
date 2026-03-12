package com.example.taskProject.domain.ports.out;

import com.example.taskProject.domain.model.Task;
import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {
    Task save(Task task);
    Optional<Task> findById(Long id);
    List<Task> findAll();
    boolean deleteById(Long id);
}