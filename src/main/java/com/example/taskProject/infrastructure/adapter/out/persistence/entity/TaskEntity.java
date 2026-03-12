package com.example.taskProject.infrastructure.adapter.out.persistence.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks") // Así se llamará la tabla en PostgreSQL
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Esto hace que el ID sea autoincrementable (1, 2, 3...)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    private boolean completed;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
