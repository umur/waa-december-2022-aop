package miu.edu.springaop.controller;

import miu.edu.springaop.aspect.annotation.ExecutionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import miu.edu.springaop.dto.UserDto;
import miu.edu.springaop.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ExecutionTime
    @GetMapping
    public List<UserDto> getAll(){
        System.out.printf("getAll %n");

        return userService.getAllUsers();
    }

    @ExecutionTime
    @GetMapping("/{id}")
    public UserDto getOne(@PathVariable int id){
        System.out.printf("getOne %s%n", id);
        return userService.getById(id);
    }

    @ExecutionTime
    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable int id){
        System.out.printf("deleteOne %s%n", id);

        userService.delete(id);
    }

    @ExecutionTime
    @PutMapping("/{id}")
    public UserDto updateOne(@RequestBody UserDto p){
        System.out.printf("update %s%n", p);

        return userService.update(p);
    }

}
