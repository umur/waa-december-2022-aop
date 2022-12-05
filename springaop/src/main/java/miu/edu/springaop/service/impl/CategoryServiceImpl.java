package miu.edu.springaop.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import miu.edu.springaop.dto.CategoryDto;
import miu.edu.springaop.entity.Category;
import miu.edu.springaop.repository.CategoryRepo;
import miu.edu.springaop.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final ModelMapper modelMapper;
    private final CategoryRepo repo;


    @Override
    public CategoryDto save(CategoryDto c) {
        var category = repo.save(modelMapper.map(c, Category.class));
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        var category = repo.findAll();
        List<CategoryDto> list = new ArrayList<>();
        category.forEach(c -> list.add(modelMapper.map(category, CategoryDto.class)));
        return list;
    }

    @Override
    public CategoryDto getById(int id) {
        var category = repo.findById(id).get();
        return  modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public CategoryDto update(CategoryDto category) {
        delete(category.getId());
        return save(category);
    }
}
