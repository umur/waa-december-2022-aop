package edu.miu.aop.service;

import edu.miu.aop.dto.ReviewDto;

public interface ReviewService {
    Iterable<ReviewDto> getAll();
    ReviewDto getById(int id);
    void save(ReviewDto review);
    void update(int id, ReviewDto review);
    void delete(int id);
}

