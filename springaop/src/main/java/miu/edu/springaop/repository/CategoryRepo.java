package miu.edu.springaop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import miu.edu.springaop.entity.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {
    Category findByName(String name);
}
