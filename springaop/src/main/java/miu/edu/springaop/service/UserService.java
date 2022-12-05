package miu.edu.springaop.service;

import miu.edu.springaop.dto.CategoryDto;
import miu.edu.springaop.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);
    List<UserDto> getAllUsers();
    UserDto getById(int id);
    void delete(int id);
    UserDto update(UserDto userDto);

}
