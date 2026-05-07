package com.task_manager.repository;

import com.task_manager.entity.Task;
import com.task_manager.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    long countByStatus(TaskStatus status);

    long countByDueDateBeforeAndStatusNot(
            LocalDate date,
            TaskStatus status
    );

    List<Task> findByAssignedToId(Long userId);
}