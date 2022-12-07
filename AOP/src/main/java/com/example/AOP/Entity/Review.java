package com.example.AOP.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="review_tbl")
public class Review {
    @Id
    private int id;
    private String element;
    @ManyToOne
    private User user;
    @ManyToOne
    private Product product;
}
