package edu.miu.labthree.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name = "Products")
public class Product {
    @Id
    private int id;
    private String name;
    private int price;
    private double rating;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Review> review;
}
