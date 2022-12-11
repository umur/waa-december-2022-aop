package com.example.AOP.Repository;

import com.example.AOP.Entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category,String> {
}

