package com.task_manager.service.impl;

import com.task_manager.dto.DashboardResponse;
import com.task_manager.enums.TaskStatus;
import com.task_manager.repository.TaskRepository;
import com.task_manager.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final TaskRepository taskRepository;

    @Override
    public DashboardResponse getDashboardStats() {

        long totalTasks = taskRepository.count();

        long todoTasks =
                taskRepository.countByStatus(TaskStatus.TODO);

        long inProgressTasks =
                taskRepository.countByStatus(TaskStatus.IN_PROGRESS);

        long completedTasks =
                taskRepository.countByStatus(TaskStatus.DONE);

        long overdueTasks =
                taskRepository.countByDueDateBeforeAndStatusNot(
                        LocalDate.now(),
                        TaskStatus.DONE
                );

        return DashboardResponse.builder()
                .totalTasks(totalTasks)
                .todoTasks(todoTasks)
                .inProgressTasks(inProgressTasks)
                .completedTasks(completedTasks)
                .overdueTasks(overdueTasks)
                .build();
    }
}
