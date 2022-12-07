package com.example.AOP.Service.ServiceImpl;

import com.example.AOP.Entity.User;
import com.example.AOP.Repository.UserRepo;
import com.example.AOP.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete(int userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public User getById(int userId) {
        return userRepo.findById(userId).get();
    }

    @Override
    public List<User> getAll() {
        var userList = new ArrayList<User>();
        userRepo.findAll().forEach(userList::add);

        return userList;
    }
}
