package com.codexsoft.tasktracking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String loginPage() {
        return "redirect:/user/registration";
    }

    @GetMapping("projectList")
    public String projectList() {
        return "redirect:/projects.html";
    }

    @GetMapping("taskPage")
    public String taskPage() {
        return "redirect:/pageOfTask.html";
    }
}
