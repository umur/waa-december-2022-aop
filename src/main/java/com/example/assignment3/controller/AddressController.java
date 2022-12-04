package com.example.assignment3.controller;

import com.example.assignment3.dto.AddressDto;
import com.example.assignment3.service.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AddressController {
    private AddressService addressService;
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @ResponseBody
    @GetMapping("/addresses")
    public List<AddressDto> getAddresses() {
        return addressService.getAddresses();
    }

    @ResponseBody
    @PostMapping("/addresses")
    public String addAddress(@RequestBody AddressDto addressDto) {
        return addressService.addAddress(addressDto);
    }

    @ResponseBody
    @PutMapping("/addresses/{addressId}")
    public String updateAddress(@PathVariable int addressId, @RequestBody AddressDto addressDto) {
        return addressService.updateAddress(addressId, addressDto);
    }

    @ResponseBody
    @DeleteMapping("/addresses/{addressId}")
    public String deleteAddress(@PathVariable int addressId) {
        return addressService.deleteAddress(addressId);
    }
}
