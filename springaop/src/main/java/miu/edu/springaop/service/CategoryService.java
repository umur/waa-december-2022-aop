package miu.edu.springaop.service;

import org.springframework.stereotype.Service;
import miu.edu.springaop.dto.AddressDto;
import miu.edu.springaop.dto.CategoryDto;
import miu.edu.springaop.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryDto save(CategoryDto category);
    List<CategoryDto> getAllCategory();
    CategoryDto getById(int id);
    void delete(int id);
    CategoryDto update(CategoryDto category);

}
