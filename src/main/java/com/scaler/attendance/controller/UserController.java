package com.scaler.attendance.controller;

import com.scaler.attendance.helper.UserData;
import com.scaler.attendance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public String addUser(@RequestBody UserData userData) {

        String name = "";
        String email = "";
        String password = "";
        String role = "";

        try {
            name = userData.getName();
            email = userData.getEmail();
            password = userData.getPassword();
            role = userData.getRole();
        }
        catch (Exception e) {
            return "User not added -- Invalid data";
        }

        if (userService.addUser(name, email, password, role)) {
            return "User added successfully";
        }
        return "User not added";
    }
}
