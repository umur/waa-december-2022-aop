package com.ujjwal.humagain.springdata.controller;

import com.ujjwal.humagain.springdata.entity.dto.AddressDto;
import com.ujjwal.humagain.springdata.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public List<AddressDto> findAll(){
        return addressService.findAll();
    }
    @GetMapping("/{id}")
    public AddressDto findById(@PathVariable int id){
        return addressService.findById(id);
    }
    @PostMapping
    public void save(@RequestBody AddressDto addressDto){
        addressService.save(addressDto);
    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody AddressDto addressDto){
        addressService.update(id, addressDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        addressService.delete(id);
    }
}
