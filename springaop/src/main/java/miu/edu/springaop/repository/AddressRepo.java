package miu.edu.springaop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import miu.edu.springaop.entity.Address;

@Repository
public interface AddressRepo extends CrudRepository<Address, Integer> {
}
