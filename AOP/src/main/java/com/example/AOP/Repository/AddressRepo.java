package com.example.AOP.Repository;

import com.example.AOP.Entity.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends CrudRepository<Address,Integer> {
}
