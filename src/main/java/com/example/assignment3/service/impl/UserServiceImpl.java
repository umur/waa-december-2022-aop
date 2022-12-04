package com.example.assignment3.service.impl;

import com.example.assignment3.dto.UserDto;
import com.example.assignment3.entity.User;
import com.example.assignment3.repo.UserRepo;
import com.example.assignment3.service.UserService;
import com.example.assignment3.service.UtilityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UtilityService utilityService;
    private UserRepo userRepo;
    private ModelMapper modelMapper;

    public  UserServiceImpl(UtilityService utilityService,UserRepo userRepo, ModelMapper modelMapper) {
        this.utilityService = utilityService;
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> getUsers() {
        List<UserDto> users = new ArrayList<>();
        Iterable<User> userIterable = userRepo.findAll();
        for(User user: userIterable) {
            users.add(modelMapper.map(user, UserDto.class));
        }
        return  users;
    }

    @Override
    public String addUser(UserDto userDto) {
        try {
            userDto.setId(utilityService.getRandomNumber());
            userRepo.save(modelMapper.map(userDto, User.class));
            return "User added successfully!";
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String deleteUser (int userId) {
        try {
            userRepo.deleteById(userId);
            return "User deleted successfully!";
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String updateUser(int userId, UserDto userDto) {
        try {
            userDto.setId((userId));
            userRepo.save(modelMapper.map(userDto, User.class));
            return "User updated successfully!";
        } catch (Exception e) {
            throw e;
        }
    }
}
