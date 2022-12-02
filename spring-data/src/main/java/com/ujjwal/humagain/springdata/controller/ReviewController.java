package com.ujjwal.humagain.springdata.controller;

import com.ujjwal.humagain.springdata.entity.dto.ReviewDto;
import com.ujjwal.humagain.springdata.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;
    @GetMapping
    public List<ReviewDto> findAll(){
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewDto findById(@PathVariable int id) {
        return reviewService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody ReviewDto reviewDto){
        reviewService.save(reviewDto);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody ReviewDto reviewDto) {
        reviewService.update(id, reviewDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        reviewService.delete(id);
    }
}
