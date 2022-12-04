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
        return categoryService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody CategoryDto category){
        categoryService.save(category);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody CategoryDto category){
        categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        categoryService.delete(id);
    }
}
