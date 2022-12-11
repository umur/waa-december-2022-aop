package com.example.AOP.Service.ServiceImpl;

import com.example.AOP.Entity.Review;
import com.example.AOP.Repository.ReviewRepo;
import com.example.AOP.Service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class ReviewImpl implements ReviewService {
    public final ReviewRepo repo;
    @Override
    public void saveorUpdate(Review review) {
       repo.save(review);

    }

    @Override
    public List<Review> getAll() {
        var rev = new ArrayList<Review>();
        repo.findAll().forEach(rev::add);
        return  rev;
    }

    @Override
    public Review get(int id) {
        return repo.findById(id).get();
    }

    @Override
    public void delete(int id) {
        repo.deleteById(id);

    }
}
