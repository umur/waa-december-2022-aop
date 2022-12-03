package edu.miu.aop.service.impl;

import edu.miu.aop.dto.ReviewDto;
import edu.miu.aop.entity.Review;
import edu.miu.aop.repository.ReviewRepo;
import edu.miu.aop.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;
    private final ModelMapper modelMapper;
    @Override
    public Iterable<ReviewDto> getAll() {
        List<ReviewDto> list = new ArrayList<>();
        var reviews = reviewRepo.findAll();
        reviews.forEach(p -> list.add(modelMapper.map(p, ReviewDto.class)));
        return list;
    }

    @Override
    public ReviewDto getById(int id) {
        return modelMapper.map(reviewRepo.findById(id).get(), ReviewDto.class);
    }

    @Override
    public void save(ReviewDto review) {
        reviewRepo.save(modelMapper.map(review, Review.class));
    }

    @Override
    public void update(int id, ReviewDto review) {
        reviewRepo.save(modelMapper.map(review, Review.class));
    }

    @Override
    public void delete(int id) {
        reviewRepo.deleteById(id);
    }
}
