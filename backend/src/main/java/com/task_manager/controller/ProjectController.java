package com.task_manager.controller;

import com.task_manager.entity.Project;
import com.task_manager.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectRepository projectRepository;

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }
}