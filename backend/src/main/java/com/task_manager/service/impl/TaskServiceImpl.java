package com.task_manager.service.impl;

import com.task_manager.dto.CreateTaskRequest;
import com.task_manager.dto.UpdateTaskStatusRequest;
import com.task_manager.entity.Project;
import com.task_manager.entity.Task;
import com.task_manager.entity.User;
import com.task_manager.enums.TaskStatus;
import com.task_manager.repository.ProjectRepository;
import com.task_manager.repository.TaskRepository;
import com.task_manager.repository.UserRepository;
import com.task_manager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final UserRepository userRepository;

    private final ProjectRepository projectRepository;

    @Override
    public Task createTask(CreateTaskRequest request) {

        User assignedUser =
                userRepository.findById(request.getAssignedUserId())
                        .orElseThrow(() ->
                                new RuntimeException("User not found"));

        Project project =
                projectRepository.findById(request.getProjectId())
                        .orElseThrow(() ->
                                new RuntimeException("Project not found"));

        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .priority(request.getPriority())
                .dueDate(request.getDueDate())
                .status(TaskStatus.TODO)
                .assignedTo(assignedUser)
                .project(project)
                .build();

        return taskRepository.save(task);
    }

    @Override
    public Task updateTaskStatus(
            Long taskId,
            UpdateTaskStatusRequest request
    ) {

        Task task =
                taskRepository.findById(taskId)
                        .orElseThrow(() ->
                                new RuntimeException("Task not found"));

        task.setStatus(request.getStatus());

        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getTasksByUser(Long userId) {

        return taskRepository.findByAssignedToId(userId);
    }
}