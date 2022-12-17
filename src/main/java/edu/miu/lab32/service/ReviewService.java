package edu.miu.lab32.service;

import edu.miu.lab32.model.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> getReviewsByProduct(int id);

}
