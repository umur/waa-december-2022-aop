package miu.edu.springaop.controller;

import miu.edu.springaop.aspect.annotation.ExecutionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import miu.edu.springaop.dto.CategoryDto;
import miu.edu.springaop.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @ExecutionTime
    @GetMapping
    public List<CategoryDto> getAll(){
        System.out.printf("getAll %n");

        return service.getAllCategory();
    }

    @ExecutionTime
    @GetMapping("/{id}")
    public CategoryDto getOne(@PathVariable int id){
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
    public CategoryDto updateOne(@RequestBody CategoryDto p){
        System.out.printf("update %s%n", p);

        return service.update(p);
    }

}
