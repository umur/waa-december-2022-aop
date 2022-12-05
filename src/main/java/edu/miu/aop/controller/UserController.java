package edu.miu.aop.controller;

import edu.miu.aop.aspect.annotation.ExecutionTime;
import edu.miu.aop.dto.UserDto;
import edu.miu.aop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @ExecutionTime
    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @ExecutionTime
    @GetMapping("/{id}")
    public UserDto findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UserDto userDto) {
        userService.save(userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.deleteById(id);
    }
}
