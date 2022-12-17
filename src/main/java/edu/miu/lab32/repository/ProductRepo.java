package edu.miu.lab32.repository;

import edu.miu.lab32.model.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
    List<Product> findProductsByPriceGreaterThan(double minPrice);

    List<Product> findProductsByCategory_NameAndPriceLessThan(String category_name, double price);

    List<Product> findAllByNameContaining(String filterText);

    Product findProductsById(int id);
}
