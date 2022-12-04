package com.example.assignment3.controller;

import com.example.assignment3.dto.ReviewDto;
import com.example.assignment3.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reviews")
@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<ReviewDto> getReviews(){
        return reviewService.getReviews();
    }

    @PostMapping
    public String getReviews(@RequestBody ReviewDto reviewDto){
        return reviewService.addReview(reviewDto);
    }

    @DeleteMapping("/{reviewId}")
    public String deleteReview(@PathVariable int reviewId){
        return reviewService.deleteReview(reviewId);
    }

    @PutMapping("/{reviewId}")
    public String deleteReview(@PathVariable int reviewId, @RequestBody ReviewDto reviewDto){
        return reviewService.updateReview(reviewId, reviewDto);
    }

    @GetMapping("/getByProductId")
    public List<ReviewDto> findAllByProduct_Id(@RequestParam int id){
        return reviewService.findAllByProduct_Id(id);
    }
}
