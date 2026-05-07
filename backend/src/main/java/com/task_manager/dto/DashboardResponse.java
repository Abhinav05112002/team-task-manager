package com.task_manager.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DashboardResponse {

    private long totalTasks;

    private long todoTasks;

    private long inProgressTasks;

    private long completedTasks;

    private long overdueTasks;
}
