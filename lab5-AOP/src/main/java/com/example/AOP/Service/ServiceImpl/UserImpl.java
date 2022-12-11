package com.example.AOP.Service.ServiceImpl;

import com.example.AOP.Entity.User;
import com.example.AOP.Repository.UserRepo;
import com.example.AOP.Service.Userservice;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class UserImpl implements Userservice {
     public UserRepo repo;
    @Override
    public void saveOrUpdate(User user) {
       repo.save(user);
    }

    @Override
    public List<User> getAll() {
        var y = new ArrayList<User>();
        repo.findAll().forEach(y::add);
        return  y;
    }

    @Override
    public void delete(int id) {
       repo.deleteById(id);
    }

    @Override
    public User getById(int id) {
        return repo.findById(id).get();
    }
}
