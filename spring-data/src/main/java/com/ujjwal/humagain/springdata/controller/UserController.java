package com.ujjwal.humagain.springdata.controller;

import com.ujjwal.humagain.springdata.aspect.annotation.ExecutionTime;
import com.ujjwal.humagain.springdata.entity.dto.UserDto;
import com.ujjwal.humagain.springdata.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    @ExecutionTime
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ExecutionTime
    public UserDto findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @PostMapping
    @ExecutionTime
    public void save(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @PutMapping("/{id}")
    @ExecutionTime
    public void update(@PathVariable int id, @RequestBody UserDto userDto) {
        userService.update(id, userDto);
    }

    @DeleteMapping("/{id}")
    @ExecutionTime
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }
}
