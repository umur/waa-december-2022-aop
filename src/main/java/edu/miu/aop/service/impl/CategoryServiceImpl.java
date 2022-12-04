package edu.miu.aop.service.impl;

import edu.miu.aop.aspect.annotation.ExecutionTime;
import edu.miu.aop.dto.CategoryDto;
import edu.miu.aop.entity.Category;
import edu.miu.aop.repository.CategoryRepo;
import edu.miu.aop.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;
    @Override
    @ExecutionTime
    public Iterable<CategoryDto> getAll() {
        List<CategoryDto> list = new ArrayList<>();
        var categories = categoryRepo.findAll();
        categories.forEach(p -> list.add(modelMapper.map(p, CategoryDto.class)));
        return list;
    }

    @Override
    public CategoryDto getById(int id) {
        return modelMapper.map(categoryRepo.findById(id).get(), CategoryDto.class);
    }

    @Override
    public void save(CategoryDto category) {
        categoryRepo.save(modelMapper.map(category, Category.class));
    }

    @Override
    public void update(int id, CategoryDto category) {
        categoryRepo.save(modelMapper.map(category, Category.class));
    }

    @Override
    public void delete(int id) {
        categoryRepo.deleteById(id);
    }
}
