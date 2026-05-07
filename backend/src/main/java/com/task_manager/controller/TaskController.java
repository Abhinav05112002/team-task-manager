package com.task_manager.controller;

import com.task_manager.dto.CreateTaskRequest;
import com.task_manager.dto.UpdateTaskStatusRequest;
import com.task_manager.entity.Task;
import com.task_manager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public Task createTask(
            @RequestBody CreateTaskRequest request
    ) {

        return taskService.createTask(request);
    }

    @PatchMapping("/{taskId}/status")
    public Task updateTaskStatus(
            @PathVariable Long taskId,
            @RequestBody UpdateTaskStatusRequest request
    ) {

        return taskService.updateTaskStatus(taskId, request);
    }

    @GetMapping
    public List<Task> getAllTasks() {

        return taskService.getAllTasks();
    }

    @GetMapping("/user/{userId}")
    public List<Task> getTasksByUser(
            @PathVariable Long userId
    ) {

        return taskService.getTasksByUser(userId);
    }
}