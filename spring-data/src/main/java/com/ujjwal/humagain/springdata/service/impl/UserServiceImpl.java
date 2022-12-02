package com.ujjwal.humagain.springdata.service.impl;

import com.ujjwal.humagain.springdata.entity.User;
import com.ujjwal.humagain.springdata.entity.dto.UserDto;
import com.ujjwal.humagain.springdata.repository.UserRepository;
import com.ujjwal.humagain.springdata.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    @Override
    public void save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
    }

    @Override
    public void update(int id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        User user = userRepository.findById(id).orElseThrow(()->new RuntimeException(("User not found")));
        userRepository.delete(user);
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(user -> modelMapper.map(user,UserDto.class)).toList();
    }

    @Override
    public UserDto findById(int id) {
        return userRepository.findById(id).map(user -> modelMapper.map(user,UserDto.class)).get();
    }
}
