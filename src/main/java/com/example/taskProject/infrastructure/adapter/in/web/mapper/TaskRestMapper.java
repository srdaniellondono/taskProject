package com.example.taskProject.infrastructure.adapter.in.web.mapper;

import com.example.taskProject.domain.model.Task;
import com.example.taskProject.infrastructure.adapter.in.web.dto.TaskRequest;
import com.example.taskProject.infrastructure.adapter.in.web.dto.TaskResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//componentModel = "spring" let us inject it in the controller with @Authowired
@Mapper(componentModel = "spring")
public interface TaskRestMapper {

    // from DTO to domain
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "completed", constant = "false")
    Task toDomain(TaskRequest request);

    // from domain to
    TaskResponse toResponse(Task task);
}