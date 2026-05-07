package com.task_manager.controller;

import com.task_manager.dto.DashboardResponse;
import com.task_manager.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/stats")
    public DashboardResponse getDashboardStats() {

        return dashboardService.getDashboardStats();
    }
}
