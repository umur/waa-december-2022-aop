package miu.edu.springaop.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.springaop.aspect.annotation.ExecutionTime;
import org.springframework.web.bind.annotation.*;
import miu.edu.springaop.dto.ReviewDto;
import miu.edu.springaop.repository.ReviewRepo;
import miu.edu.springaop.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    private final ReviewRepo repo;

    @ExecutionTime
    @GetMapping
    public List<ReviewDto> getAll(){
        System.out.printf("getAll %n");

        return reviewService.getAllReview();
    }

    @ExecutionTime
    @GetMapping("/{id}")
    public ReviewDto getOne(@PathVariable int id){
        System.out.printf("getOne %s%n", id);
        return reviewService.getById(id);
    }

    @ExecutionTime
    @GetMapping("/filterByProductId")
    public List<ReviewDto> getByProductId(@RequestParam int productId){
        System.out.printf("getAll %n");

        return reviewService.getReviewByProduct(productId);
    }

    @ExecutionTime
    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable int id){
        System.out.printf("deleteOne %s%n", id);

        reviewService.delete(id);
    }

    @ExecutionTime
    @PutMapping("/{id}")
    public ReviewDto updateOne(@RequestBody ReviewDto p){
        System.out.printf("update %s%n", p);

        return reviewService.update(p);
    }


}
