package com.example.AOP.Controller;

import com.example.AOP.Entity.User;
import com.example.AOP.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lab3/user")
public class UserController {
    private final UserService userService;

    @PostMapping
    public String create(@RequestBody User user) {
        try {
            userService.save(user);

            return "User saved successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while saving User.";
        }
    }

    @PutMapping
    public String update(@RequestBody User user) {
        try {
            userService.save(user);

            return "User updated successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while updating User.";
        }
    }

    @DeleteMapping("/{userId}")
    public String delete(@PathVariable int userId) {
        try {
            userService.delete(userId);

            return "User deleted successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while deleting User.";
        }
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{userId}")
    public User getById(@PathVariable int userId) {
        return userService.getById(userId);
    }

}
