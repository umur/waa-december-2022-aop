package com.example.AOP.Service;

import com.example.AOP.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    void save(User user);

    void delete(int userId);

    User getById(int userId);

    List<User> getAll();
}
