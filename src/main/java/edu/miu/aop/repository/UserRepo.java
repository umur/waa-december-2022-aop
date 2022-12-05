package edu.miu.aop.repository;

import edu.miu.aop.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Ankhbayar Azzaya
 */
public interface UserRepo extends CrudRepository<User, Integer> {

}
