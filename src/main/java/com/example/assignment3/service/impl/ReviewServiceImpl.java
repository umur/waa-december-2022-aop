package com.example.assignment3.service.impl;

import com.example.assignment3.dto.ReviewDto;
import com.example.assignment3.entity.Review;
import com.example.assignment3.repo.ReviewRepo;
import com.example.assignment3.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepo reviewRepo;
    private ModelMapper modelMapper;
    public ReviewServiceImpl(ReviewRepo reviewRepo, ModelMapper modelMapper) {
        this.reviewRepo = reviewRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ReviewDto> getReviews() {
        Iterable<Review> reviews = reviewRepo.findAll();
        List<ReviewDto> reviewList = new ArrayList<>();
        reviews.forEach(review -> {
           reviewList.add(modelMapper.map(review, ReviewDto.class));
        });
        return reviewList;
    }

    @Override
    public String addReview(ReviewDto reviewDto) {
        try {
            reviewRepo.save(modelMapper.map(reviewDto, Review.class));
            return "Review added successfully!";
        } catch(Exception e) {
            throw e;
//            return "Error while adding review!";
        }
    }

    @Override
    public String deleteReview(int reviewId) {
        try {
            reviewRepo.deleteById(reviewId);
            return "Review deleted successfully!";
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String updateReview(int reviewId, ReviewDto reviewDto) {
        try {
            reviewDto.setId(reviewId);
            reviewRepo.save(modelMapper.map(reviewDto, Review.class));
            return "Review updated successfully!";
        } catch(Exception e) {
            throw e;
        }
    }

    @Override
    public List<ReviewDto> findAllByProduct_Id(int productId) {
        return reviewRepo.findByProduct_Id(productId).stream()
                .map(review -> modelMapper.map(review, ReviewDto.class))
                .toList();
    }
}
