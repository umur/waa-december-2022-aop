package com.example.AOP.Controller;
import com.example.AOP.Entity.Review;
import com.example.AOP.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/lab3/review")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public String create(@RequestBody Review review) {
        try {
            reviewService.save(review);

            return "Review saved successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while saving Review.";
        }
    }

    @PutMapping
    public String update(@RequestBody Review review) {
        try {
            reviewService.save(review);

            return "Review updated successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while updating Review.";
        }
    }

    @DeleteMapping("/{reviewId}")
    public String delete(@PathVariable int reviewId) {
        try {
            reviewService.delete(reviewId);

            return "Review deleted successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while deleting Review.";
        }
    }

    @GetMapping
    public List<Review> getAll() {
        return reviewService.getAll();
    }

    @GetMapping("/{reviewId}")
    public Review getById(@PathVariable int reviewId) {
        return reviewService.getById(reviewId);
    }
}
