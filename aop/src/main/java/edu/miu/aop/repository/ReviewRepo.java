package edu.miu.aop.repository;

import edu.miu.aop.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Long> {

    //List<Review> findByProductId(Long productId);
}
