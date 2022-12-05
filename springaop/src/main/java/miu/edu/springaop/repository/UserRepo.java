package miu.edu.springaop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import miu.edu.springaop.entity.User;
@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
}
