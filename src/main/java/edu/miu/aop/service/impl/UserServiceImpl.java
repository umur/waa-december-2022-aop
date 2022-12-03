package edu.miu.aop.service.impl;

import edu.miu.aop.dto.UserDto;
import edu.miu.aop.entity.User;
import edu.miu.aop.repository.UserRepo;
import edu.miu.aop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;
    @Override
    public Iterable<UserDto> getAll() {
        List<UserDto> list = new ArrayList<>();
        var users = userRepo.findAll();
        users.forEach(p -> list.add(modelMapper.map(p, UserDto.class)));
        return list;
    }

    @Override
    public UserDto getById(int id) {
        return modelMapper.map(userRepo.findById(id).get(), UserDto.class);
    }

    @Override
    public void save(UserDto user) {
        userRepo.save(modelMapper.map(user, User.class));
    }

    @Override
    public void update(int id, UserDto user) {
        userRepo.save(modelMapper.map(user, User.class));
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }
}
