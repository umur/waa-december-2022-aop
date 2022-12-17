package edu.miu.lab32.controller;

import edu.miu.lab32.model.dto.ReviewDTO;
import edu.miu.lab32.service.ProductService;
import edu.miu.lab32.service.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;
    private final ProductService productService;

    public ReviewController(ReviewService reviewService, ProductService productService) {
        this.reviewService = reviewService;
        this.productService = productService;
    }

    @GetMapping("/filter") // localhost/reviews/filter?productId=1
    public List<ReviewDTO> getProductsByNameContaining(@RequestParam int productId) {
        return reviewService.getReviewsByProduct(productId);
    }
}

