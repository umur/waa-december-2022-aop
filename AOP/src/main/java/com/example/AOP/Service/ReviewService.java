package com.example.AOP.Service;

import com.example.AOP.Entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    void save(Review review);

    void delete(int reviewId);

    Review getById(int reviewId);

    List<Review> getAll();
}
