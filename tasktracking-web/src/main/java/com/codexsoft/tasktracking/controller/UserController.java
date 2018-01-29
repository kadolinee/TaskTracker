package com.codexsoft.tasktracking.controller;

import com.codexsoft.tasktracking.entity.Role;
import com.codexsoft.tasktracking.entity.User;
import com.codexsoft.tasktracking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/", "registration"})
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("registration")
    public String loginSubmit(@ModelAttribute("user") User user) {
        user.setRole(new Role(Long.parseLong(user.getRoleId())));
        userService.create(user);
        return "projects";
    }

    @GetMapping("projectList")
    public String projectList(Model model) {
        return "redirect:/projects.html";
    }

}
