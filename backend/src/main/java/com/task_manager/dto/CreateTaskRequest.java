package com.task_manager.dto;

import com.task_manager.enums.Priority;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateTaskRequest {

    private String title;

    private String description;

    private Priority priority;

    private LocalDate dueDate;

    private Long assignedUserId;

    private Long projectId;
}