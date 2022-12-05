package edu.miu.mae.repository;

import edu.miu.mae.entity.Product;
import edu.miu.mae.entity.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product,Integer> {

    List<Product> getAllByPriceGreaterThan(double price);

    List<Product> getAllByNameContaining(String keyword);

    @Query(value = "SELECT * FROM PRODUCT p join Category c on p.id_category = c.id where c.name= ?1 and p.price < ?2 ",
            nativeQuery = true)
    List<Product> getAllProductsByCategoryAndPrice(String categoryName, double maxPrice);

}
