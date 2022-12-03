package edu.miu.aop.controller;

import edu.miu.aop.dto.UserDto;
import edu.miu.aop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    public final UserService userService;

    @GetMapping
    public Iterable<UserDto> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable int id){
        System.out.println("Get request received for id: " + String.valueOf(id));
        return userService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody UserDto user){
        System.out.println("Post request received: " + user.toString());
        userService.save(user);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UserDto user){
        System.out.println("Update request received for id: " + String.valueOf(id) + " with request body: " + user.toString());
        userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        System.out.println("Delete request received for id: " + String.valueOf(id));
        userService.delete(id);
    }
}
