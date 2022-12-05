package miu.edu.springaop.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import miu.edu.springaop.dto.CategoryDto;
import miu.edu.springaop.dto.ReviewDto;
import miu.edu.springaop.entity.Review;
import miu.edu.springaop.repository.ReviewRepo;
import miu.edu.springaop.service.ReviewService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ModelMapper mapper;
    private final ReviewRepo repo;
    @Override
    public ReviewDto save(ReviewDto r) {
        var review = repo.save(mapper.map(r, Review.class));
        return mapper.map(review, ReviewDto.class);
    }

    @Override
    public List<ReviewDto> getAllReview() {
        var review = repo.findAll();
        List<ReviewDto> l = new ArrayList<>();
        review.forEach(r -> l.add(mapper.map(r, ReviewDto.class)));

        return l;
    }

    @Override
    public ReviewDto getById(int id) {
        var review = repo.findById(id).get();
        return mapper.map(review, ReviewDto.class);
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);
    }

    @Override
    public ReviewDto update(ReviewDto r) {
        delete(r.getId());
        return save(r);
    }

    @Override
    public List<ReviewDto> getReviewByProduct(int prodId) {
        var reviews = repo.findReviewsByProductId(prodId);
        List<ReviewDto> l = new ArrayList<>();
        reviews.forEach(r -> l.add(mapper.map(r, ReviewDto.class)));

        return l;
    }
}
