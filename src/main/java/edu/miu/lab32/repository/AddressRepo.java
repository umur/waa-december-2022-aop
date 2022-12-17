package edu.miu.lab32.repository;

import edu.miu.lab32.model.entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo  extends CrudRepository<Address, Integer> {

}
