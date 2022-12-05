package edu.miu.aop.service;

import edu.miu.aop.dto.CategoryDto;
import edu.miu.aop.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Ankhbayar Azzaya
 */
@Service
public interface CategoryService {

    void save(CategoryDto categoryDto);

    CategoryDto findById(int id);

    List<CategoryDto> findAll();

    void delete(int id);

    void update(int id, CategoryDto categoryDto);

}
