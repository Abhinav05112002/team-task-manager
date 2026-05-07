package com.task_manager.dto;

import com.task_manager.enums.TaskStatus;
import lombok.Data;

@Data
public class UpdateTaskStatusRequest {

    private TaskStatus status;
}