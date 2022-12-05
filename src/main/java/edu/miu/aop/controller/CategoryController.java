package edu.miu.aop.controller;

import edu.miu.aop.aspect.annotation.ExecutionTime;
import edu.miu.aop.dto.CategoryDto;
import edu.miu.aop.entity.Category;
import edu.miu.aop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
@RequiredArgsConstructor
@RequestMapping("/categories")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @ExecutionTime
    @GetMapping
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @ExecutionTime
    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable int id) {
        System.out.println("getById: " + id);
        return categoryService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody CategoryDto categoryDto) {
        categoryService.save(categoryDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody CategoryDto categoryDto) {
        categoryService.update(id, categoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        categoryService.delete(id);
    }

}
