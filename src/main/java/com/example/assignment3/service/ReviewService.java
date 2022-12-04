package com.example.assignment3.service;

import com.example.assignment3.dto.ReviewDto;
import com.example.assignment3.entity.Review;

import java.util.List;

public interface ReviewService {
    public List<ReviewDto> getReviews();
    public String addReview(ReviewDto reviewDto);
    public String deleteReview(int reviewId);
    public String updateReview(int reviewId, ReviewDto reviewDto);
    public List<ReviewDto> findAllByProduct_Id(int productId);
}
