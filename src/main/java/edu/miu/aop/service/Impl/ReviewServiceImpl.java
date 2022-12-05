package edu.miu.aop.service.Impl;

import edu.miu.aop.dto.ProductDto;
import edu.miu.aop.dto.ReviewDto;
import edu.miu.aop.entity.Review;
import edu.miu.aop.repository.ReviewRepo;
import edu.miu.aop.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;
    private final ModelMapper mapper;

    @Override
    public void save(ReviewDto reviewDto) {
        reviewRepo.save(mapper.map(reviewDto, Review.class));
    }

    @Override
    public ReviewDto findById(int id) {
        return mapper.map(reviewRepo.findById(id).get(), ReviewDto.class);
    }

    @Override
    public List<ReviewDto> findAll() {
        List<ReviewDto> reviewDtos = new ArrayList<>();
        reviewRepo.findAll().forEach(review -> reviewDtos.add(mapper.map(review, ReviewDto.class)));
        return reviewDtos;
    }

    @Override
    public void delete(int id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public void update(int id, ReviewDto reviewDto) {
        reviewRepo.save(mapper.map(reviewDto, Review.class));
    }

    @Override
    public List<ReviewDto> findReviewsByProductId(int productId) {
        return reviewRepo.findReviewsByProductId(productId)
                .stream()
                .map(review -> mapper.map(review, ReviewDto.class))
                .toList();
    }

}
