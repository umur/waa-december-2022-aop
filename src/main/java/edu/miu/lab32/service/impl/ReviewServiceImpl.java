package edu.miu.lab32.service.impl;

import edu.miu.lab32.model.dto.ReviewDTO;
import edu.miu.lab32.model.entity.Review;
import edu.miu.lab32.repository.ReviewRepo;
import edu.miu.lab32.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;
    private final ModelMapper modelMapper = new ModelMapper();
    private final Function<Review, ReviewDTO> reviewMapper = review -> modelMapper.map(review, ReviewDTO.class);

    public ReviewServiceImpl(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;

    }

    @Override
    public List<ReviewDTO> getReviewsByProduct(int id) {
        List<Review> reviewsByProductId = reviewRepo.findReviewsByProductId(id);

        return reviewsByProductId.stream()
                .map(reviewMapper)
                .toList();
    }
}

