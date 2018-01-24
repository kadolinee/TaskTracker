package com.codexsoft.tasktracking.controller;

import com.codexsoft.tasktracking.entity.Project;
import com.codexsoft.tasktracking.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<Map<String, List<Project>>> findAll() {
        Map<String, List<Project>> projects = new HashMap<>();
        projects.put("projects", projectService.findAll());
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody Project project) {
        projectService.create(project);
        return new ResponseEntity<>(project, HttpStatus.CREATED);
    }
}
