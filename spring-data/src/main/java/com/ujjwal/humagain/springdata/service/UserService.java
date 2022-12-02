package com.ujjwal.humagain.springdata.service;

import com.ujjwal.humagain.springdata.entity.dto.UserDto;

import java.util.List;

public interface UserService {
    void save(UserDto userDto);
    void update(int id, UserDto userDto);
    void delete(int id);
    List<UserDto> findAll();
    UserDto findById(int id);
}
