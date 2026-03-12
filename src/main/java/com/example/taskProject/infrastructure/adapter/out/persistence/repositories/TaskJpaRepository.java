package com.example.taskProject.infrastructure.adapter.out.persistence.repositories;
import com.example.taskProject.infrastructure.adapter.out.persistence.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskJpaRepository extends JpaRepository<TaskEntity,Long> {}
