package edu.miu.aop.repository;

import edu.miu.aop.entity.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
public interface ReviewRepo extends CrudRepository<Review, Integer> {
    List<Review> findReviewsByProductId(int productId);
}
