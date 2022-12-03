package edu.miu.aop.controller;

import edu.miu.aop.dto.AddressDto;
import edu.miu.aop.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/addresses")
@RestController
public class AddressController {

    public final AddressService addressService;

    @GetMapping
    public Iterable<AddressDto> getAll(){
        return addressService.getAll();
    }

    @GetMapping("/{id}")
    public AddressDto getById(@PathVariable int id){
        System.out.println("Get request received for id: " + String.valueOf(id));
        return addressService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody AddressDto address){
        System.out.println("Post request received: " + address.toString());
        addressService.save(address);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody AddressDto address){
        System.out.println("Update request received for id: " + String.valueOf(id) + " with request body: " + address.toString());
        addressService.update(id, address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        System.out.println("Delete request received for id: " + String.valueOf(id));
        addressService.delete(id);
    }
}
