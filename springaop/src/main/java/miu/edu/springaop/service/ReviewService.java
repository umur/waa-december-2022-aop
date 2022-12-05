package miu.edu.springaop.service;

import miu.edu.springaop.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    ReviewDto save(ReviewDto r);
    List<ReviewDto> getAllReview();
    ReviewDto getById(int id);
    void delete(int id);
    ReviewDto update(ReviewDto r);
    List<ReviewDto> getReviewByProduct(int prodId);

}
