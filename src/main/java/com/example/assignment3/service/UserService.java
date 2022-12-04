package com.example.assignment3.service;

import com.example.assignment3.dto.UserDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    public List<UserDto> getUsers();
    public String addUser(UserDto userDto);
    public String deleteUser (int userId) ;
    public String updateUser(int userId, UserDto userDto);
}
