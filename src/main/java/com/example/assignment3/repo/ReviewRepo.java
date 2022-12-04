package com.example.assignment3.repo;

import com.example.assignment3.dto.ReviewDto;
import com.example.assignment3.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Integer> {
    public List<Review> findByProduct_Id(int productId);
}
