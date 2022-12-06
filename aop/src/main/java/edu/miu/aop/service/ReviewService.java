package edu.miu.aop.service;

import edu.miu.aop.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

    void save(Review review);

    void delete(Long reviewId);

    Review getById(Long reviewId);

    List<Review> getAll();

}
