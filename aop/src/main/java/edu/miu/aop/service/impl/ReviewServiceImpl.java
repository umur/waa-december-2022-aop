package edu.miu.aop.service.impl;

import edu.miu.aop.entity.Review;
import edu.miu.aop.repository.ReviewRepo;
import edu.miu.aop.service.ReviewService;
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
    public void delete(Long reviewId) {
        reviewRepo.deleteById(reviewId);
    }

    @Override
    public Review getById(Long reviewId) {
        return reviewRepo.findById(reviewId).get();
    }

    @Override
    public List<Review> getAll() {
        var reviewList = new ArrayList<Review>();
        reviewRepo.findAll().forEach(reviewList::add);

        return reviewList;
    }
}
