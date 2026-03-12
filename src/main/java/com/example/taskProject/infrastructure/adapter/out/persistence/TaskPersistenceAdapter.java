package com.example.taskProject.infrastructure.adapter.out.persistence;

import com.example.taskProject.domain.model.Task;
import com.example.taskProject.domain.ports.out.TaskRepositoryPort;
import com.example.taskProject.infrastructure.adapter.out.persistence.entity.TaskEntity;
import com.example.taskProject.infrastructure.adapter.out.persistence.repositories.TaskJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class TaskPersistenceAdapter implements TaskRepositoryPort {

    private final TaskJpaRepository repository;

    // Inyección de dependencias creando el constructor con el objeto repository
    public TaskPersistenceAdapter(TaskJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task save(Task task) {
        TaskEntity entity = toEntity(task);
        TaskEntity savedEntity = repository.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return repository.findById(id).map(this::toDomain);
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll().stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    private TaskEntity toEntity(Task task) {
        return new TaskEntity(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getCreatedAt()
        );
    }

    private Task toDomain(TaskEntity entity) {
        return new Task(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.isCompleted(),
                entity.getCreatedAt()
        );
    }
}