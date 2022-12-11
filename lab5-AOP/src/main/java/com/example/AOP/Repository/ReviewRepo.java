package com.example.AOP.Repository;

import com.example.AOP.Entity.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepo extends CrudRepository<Review,Integer> {
}
