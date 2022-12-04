package com.example.assignment3.service.impl;

import com.example.assignment3.aspect.annotation.ExecutionTime;
import com.example.assignment3.aspect.annotation.Logger;
import com.example.assignment3.dto.AddressDto;
import com.example.assignment3.entity.Address;
import com.example.assignment3.repo.AddressRepo;
import com.example.assignment3.service.AddressService;
import com.example.assignment3.service.UtilityService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepo addressRepo;
    private ModelMapper modelMapper;
    private UtilityService utilityService;
    public AddressServiceImpl(AddressRepo addressRepo, ModelMapper modelMapper, UtilityService utilityService) {
        this.addressRepo = addressRepo;
        this.modelMapper = modelMapper;
        this.utilityService = utilityService;
    }

    @ExecutionTime
    @Logger
    @Override
    public List<AddressDto> getAddresses() {
        List<AddressDto> addressList = new ArrayList<>();
        Iterable<Address> addressIterable = addressRepo.findAll();
        for(Address address: addressIterable) {
            addressList.add(modelMapper.map(address, AddressDto.class));
        }
        return addressList;
    }

    @Override
    public String addAddress(AddressDto addressDto) {
        try {
            addressDto.setId(utilityService.getRandomNumber());
            addressRepo.save(modelMapper.map(addressDto, Address.class));
            return "Address added successfully!";
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String deleteAddress(int addressId){
        try {
            addressRepo.deleteById(addressId);
            return "Address deleted successfully!";
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String updateAddress(int addressId, AddressDto addressDto) {
        try {
            addressDto.setId(addressId);
            addressRepo.save(modelMapper.map(addressDto, Address.class));
            return "Address updated successfully!";
        } catch (Exception e) {
            throw e;
        }
    }
}
