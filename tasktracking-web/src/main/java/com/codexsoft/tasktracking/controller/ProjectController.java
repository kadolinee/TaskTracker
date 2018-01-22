package com.codexsoft.tasktracking.controller;

import com.codexsoft.tasktracking.entity.Project;
import com.codexsoft.tasktracking.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Map<String, List<Project>> projects = new HashMap<>(1);
        projects.put("projects", projectService.findAll());
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }
}
