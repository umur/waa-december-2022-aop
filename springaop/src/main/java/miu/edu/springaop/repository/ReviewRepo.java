package miu.edu.springaop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import miu.edu.springaop.entity.Review;

import java.util.List;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Integer> {
    List<Review> findReviewsByProductId(int productId);
}
