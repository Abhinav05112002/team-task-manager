package com.task_manager.service;



import com.task_manager.dto.CreateTaskRequest;
import com.task_manager.dto.UpdateTaskStatusRequest;
import com.task_manager.entity.Task;

import java.util.List;

public interface TaskService {

    Task createTask(CreateTaskRequest request);

    Task updateTaskStatus(
            Long taskId,
            UpdateTaskStatusRequest request
    );

    List<Task> getAllTasks();

    List<Task> getTasksByUser(Long userId);
}
