package edu.miu.aop.repository;

import edu.miu.aop.entity.Category;
import edu.miu.aop.entity.Product;
import edu.miu.aop.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {

    List<Product> findAllByPriceGreaterThan(double minPrice);

    //List<Product> findAllByCategoryAndPriceLessThan(Category cat, double maxPrice);

    List<Product> findAllByNameContaining(String name);

}
