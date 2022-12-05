package edu.miu.aop.service.Impl;

import edu.miu.aop.dto.UserDto;
import edu.miu.aop.entity.User;
import edu.miu.aop.repository.UserRepo;
import edu.miu.aop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final ModelMapper mapper;

    @Override
    public List<UserDto> findAll() {
        List<UserDto> userDtos = new ArrayList<>();
        userRepo.findAll().forEach(user -> {
            if (!user.isDeleted())
                userDtos.add(mapper.map(user, UserDto.class));
        });
        return userDtos;
    }

    @Override
    public UserDto findById(int id) {
        return mapper.map(userRepo.findById(id).get(), UserDto.class);
    }

    @Override
    public void deleteById(int id) {
        User user = userRepo.findById(id).get();
        user.setDeleted(true);
        userRepo.save(user);
//        userRepo.deleteById(id);
    }

    @Override
    public void update(int id, UserDto userDto) {
        userRepo.save(mapper.map(userDto, User.class));
    }

    @Override
    public void save(UserDto userDto) {
        userRepo.save(mapper.map(userDto, User.class));
    }
}
