package miu.edu.springaop.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.springaop.aspect.annotation.ExecutionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import miu.edu.springaop.dto.AddressDto;
import miu.edu.springaop.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor

public class AddressController {
    private final AddressService service;

    @ExecutionTime
    @GetMapping
    public List<AddressDto> getAll(){
        System.out.printf("getAll %n");

        return service.getAllAddress();
    }

    @ExecutionTime
    @GetMapping("/{id}")
    public AddressDto getOne(@PathVariable int id){
        System.out.printf("getOne %s%n", id);
        return service.getById(id);
    }

    @ExecutionTime
    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable int id){
        System.out.printf("deleteOne %s%n", id);

        service.delete(id);
    }

    @ExecutionTime
    @PutMapping("/{id}")
    public AddressDto updateOne(@RequestBody AddressDto p){
        System.out.printf("update %s%n", p);

        return service.update(p);
    }

}
