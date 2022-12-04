package com.example.assignment3.service;

import com.example.assignment3.dto.AddressDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AddressService {
    public List<AddressDto> getAddresses();
    public String addAddress(AddressDto addressDto);
    public String deleteAddress(int addressId);
    public String updateAddress(int addressId, AddressDto addressDto);
}
