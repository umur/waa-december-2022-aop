package edu.miu.waa.service;

import java.util.List;

import edu.miu.waa.model.dto.ReviewDTO;

public interface IReviewService {
    List<ReviewDTO> getReviewsByProduct(int id);
}
