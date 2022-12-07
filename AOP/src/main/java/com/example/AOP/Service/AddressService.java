package com.example.AOP.Service;

import com.example.AOP.Entity.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    void save(Address address);

    void delete(int addressId);

    Address getById(int addressId);

    List<Address> getAll();
}
