package com.example.AOP.Controller;

import com.example.AOP.Entity.User;
import com.example.AOP.Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserController {
    @Autowired
    public Userservice serv;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        serv.delete(id);
    }
    @GetMapping
    public List<User> GetAll() {
        return serv.getAll();
    }

    @PostMapping
    public void add(@RequestBody User user) {
        serv.saveOrUpdate(user);
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return serv.getById(id);
    }
    @PutMapping
    public void update(@RequestBody User user) {
        serv.saveOrUpdate(user);
    }


}
