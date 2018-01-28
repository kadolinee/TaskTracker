package com.codexsoft.tasktracking.controller;

import com.codexsoft.tasktracking.entity.Task;
import com.codexsoft.tasktracking.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<Map<String, List<Task>>> findAll() {
        Map<String, List<Task>> tasks = new HashMap<>();
        tasks.put("tasks", taskService.findAll());
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task) {
        taskService.create(task);
        return new ResponseEntity<>(task, HttpStatus.CREATED);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable long taskId) {
        return new ResponseEntity<>(taskService.find(taskId), HttpStatus.OK);
    }

    @PutMapping("/{taskId}/{statusId}")
    public ResponseEntity<Task> changeStatus(@PathVariable long taskId, @PathVariable long statusId) {
        return new ResponseEntity<>(taskService.updateStatus(taskId, statusId), HttpStatus.OK);
    }

}
