package com.example.AOP.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="product_tbl")
public class Product {
    @Id
    private int id;
    private String name;
    private int price;
    private int rating;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Review> review;
}
