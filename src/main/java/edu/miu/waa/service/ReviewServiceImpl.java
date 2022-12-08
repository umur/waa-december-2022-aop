package edu.miu.waa.service;

import java.util.List;
import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import edu.miu.waa.model.Review;
import edu.miu.waa.model.dto.ReviewDTO;
import edu.miu.waa.repository.ReviewRepo;

@Service
public class ReviewServiceImpl implements IReviewService {

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
