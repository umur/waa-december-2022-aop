package com.example.AOP.Controller;

import com.example.AOP.Entity.Address;
import com.example.AOP.Service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lab3/address")
public class AddressController {
    private final AddressService addressService;

    @PostMapping
    public String create(@RequestBody Address address) {
        try {
            addressService.save(address);

            return "Address saved successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while saving Address.";
        }
    }

    @PutMapping
    public String update(@RequestBody Address address) {
        try {
            addressService.save(address);

            return "Address updated successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while updating Address.";
        }
    }

    @DeleteMapping("/{addressId}")
    public String delete(@PathVariable int addressId) {
        try {
            addressService.delete(addressId);

            return "Address deleted successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while deleting Address.";
        }
    }

    @GetMapping
    public List<Address> getAll() {
        return addressService.getAll();
    }

    @GetMapping("/{addressId}")
    public Address getById(@PathVariable int addressId) {
        return addressService.getById(addressId);
    }

}
