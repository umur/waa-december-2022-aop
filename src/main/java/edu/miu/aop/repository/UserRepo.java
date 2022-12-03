package edu.miu.aop.repository;

import edu.miu.aop.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
}
