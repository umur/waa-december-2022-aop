package edu.miu.aop.service.impl;

import edu.miu.aop.entity.Address;
import edu.miu.aop.repository.AddressRepo;
import edu.miu.aop.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;

    @Override
    public void save(Address address) {
        addressRepo.save(address);
    }

    @Override
    public void delete(Long addressId) {
        addressRepo.deleteById(addressId);
    }

    @Override
    public Address getById(Long addressId) {
        return addressRepo.findById(addressId).get();
    }

    @Override
    public List<Address> getAll() {
        var addressList = new ArrayList<Address>();
        addressRepo.findAll().forEach(addressList::add);

        return addressList;
    }
}
