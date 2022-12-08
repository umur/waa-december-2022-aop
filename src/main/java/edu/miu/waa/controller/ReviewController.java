package edu.miu.waa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.waa.model.dto.ReviewDTO;
import edu.miu.waa.service.IProductService;
import edu.miu.waa.service.IReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final IReviewService reviewService;
    private final IProductService productService;

    public ReviewController(IReviewService reviewService, IProductService productService) {
        this.reviewService = reviewService;
        this.productService = productService;
    }

    @GetMapping("/filter") // localhost/reviews/filter?productId=1
    public List<ReviewDTO> getProductsByNameContaining(@RequestParam int productId) {
        return reviewService.getReviewsByProduct(productId);
    }
}
