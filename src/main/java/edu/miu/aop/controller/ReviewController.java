package edu.miu.aop.controller;

import edu.miu.aop.aspect.annotation.ExecutionTime;
import edu.miu.aop.dto.ReviewDto;
import edu.miu.aop.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @ExecutionTime
    @GetMapping
    public List<ReviewDto> findAll() {
        return reviewService.findAll();
    }

    @ExecutionTime
    @GetMapping("/{id}")
    public ReviewDto findById(@PathVariable int id) {
        return reviewService.findById(id);
    }

    @ExecutionTime
    @GetMapping("/findAllReviewsByProductId")
    public List<ReviewDto> findAllReviewsByProductId(@RequestParam int productId) {
        return reviewService.findReviewsByProductId(productId);
    }

    @PostMapping
    public void create(@RequestBody ReviewDto reviewDto) {
        reviewService.save(reviewDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody ReviewDto reviewDto) {
        reviewService.save(reviewDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        reviewService.delete(id);
    }

}
