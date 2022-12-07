package com.example.AOP.Service.ServiceImpl;

import com.example.AOP.Entity.Review;
import com.example.AOP.Repository.ReviewRepo;
import com.example.AOP.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;

    @Override
    public void save(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public void delete(int reviewId) {
        reviewRepo.deleteById(reviewId);
    }

    @Override
    public Review getById(int reviewId) {
        return reviewRepo.findById(reviewId).get();
    }

    @Override
    public List<Review> getAll() {
        var reviewList = new ArrayList<Review>();
        reviewRepo.findAll().forEach(reviewList::add);

        return reviewList;
    }
}
