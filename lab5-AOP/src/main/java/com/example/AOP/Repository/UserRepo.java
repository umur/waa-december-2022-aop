package com.example.AOP.Repository;

import com.example.AOP.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Integer> {
}
