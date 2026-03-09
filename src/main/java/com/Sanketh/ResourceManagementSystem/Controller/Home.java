package com.Sanketh.ResourceManagementSystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class Home {
    @GetMapping()
    public String home() {
        return "Welcome to the Resource Management System!";
    }

    @GetMapping("/about")
    public String about() {
        return "This is a simple resource management system built with Spring Boot.";
    }
}

