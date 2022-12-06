package edu.miu.aop.controller;

import edu.miu.aop.aspect.annotation.ExecutionTime;
import edu.miu.aop.entity.Review;
import edu.miu.aop.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/aop/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @ExecutionTime
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

    @ExecutionTime
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

    @ExecutionTime
    @DeleteMapping("/{reviewId}")
    public String delete(@PathVariable Long reviewId) {
        try {
            reviewService.delete(reviewId);

            return "Review deleted successfully.";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error occurred while deleting Review.";
        }
    }

    @ExecutionTime
    @GetMapping
    public List<Review> getAll() {
        return reviewService.getAll();
    }

    @ExecutionTime
    @GetMapping("/{reviewId}")
    public Review getById(@PathVariable Long reviewId) {
        return reviewService.getById(reviewId);
    }

}
