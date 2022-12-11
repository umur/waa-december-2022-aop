package com.example.AOP.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Product {
    @Id
    private int id;
    private String name;
    private String rating;
    @OneToOne
    private Category category;
    @JoinColumn
   @OneToMany(mappedBy = "prodReview")
    List<Review>reviews;

}
