package com.Sanketh.ResourceManagementSystem.Controller;

import com.Sanketh.ResourceManagementSystem.Entity.User;
import com.Sanketh.ResourceManagementSystem.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class Home {
    private final UserService userService;


    public Home(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String home() {
        return "Welcome to the Resource Management System!";
    }

    @GetMapping("/about")
    public String about() {
        return "This is a simple resource management system built with Spring Boot.";
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User usersave=userService.saveUser(user);
        return new ResponseEntity<>(usersave,HttpStatus.OK);


    }
}

