package com.example.assignment3.controller;

import com.example.assignment3.dto.UserDto;
import com.example.assignment3.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return  userService.getUsers();
    }

    @ResponseBody
    @PostMapping("/users")
    public String addUser(@RequestBody UserDto userDto) {
        return  userService.addUser(userDto);
    }

    @ResponseBody
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {
        return  userService.deleteUser(userId);
    }

    @ResponseBody
    @PutMapping("/users/{userId}")
    public String updateUser(@PathVariable int userId, @RequestBody UserDto userDto) {
        return  userService.updateUser(userId, userDto);
    }
}
