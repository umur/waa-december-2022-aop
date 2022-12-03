package edu.miu.aop.controller;

import edu.miu.aop.dto.CategoryDto;
import edu.miu.aop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/categories")
@RestController
public class CategoryController {

    public final CategoryService categoryService;

    @GetMapping
    public Iterable<CategoryDto> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public CategoryDto getById(@PathVariable int id){
        System.out.println("Get request received for id: " + String.valueOf(id));
        return categoryService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody CategoryDto category){
        System.out.println("Post request received: " + category.toString());
        categoryService.save(category);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody CategoryDto category){
        System.out.println("Update request received for id: " + String.valueOf(id) + " with request body: " + category.toString());
        categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        System.out.println("Delete request received for id: " + String.valueOf(id));
        categoryService.delete(id);
    }
}
