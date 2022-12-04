package edu.miu.aop.controller;

import edu.miu.aop.aspect.annotation.ExecutionTime;
import edu.miu.aop.dto.UserDto;
import edu.miu.aop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
//@ExecutionTime
public class UserController {

    public final UserService userService;

    @GetMapping
    public Iterable<UserDto> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable int id){
        return userService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody UserDto user){
        userService.save(user);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UserDto user){
        userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        userService.delete(id);
    }
}
