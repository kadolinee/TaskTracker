package com.codexsoft.tasktracking.controller;

import com.codexsoft.tasktracking.entity.User;
import com.codexsoft.tasktracking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    public ModelAndView registerUserAccount
            (@ModelAttribute("user") User account) {
        userService.create(account);
        return new ModelAndView("successRegister", "user", account);
    }

}
