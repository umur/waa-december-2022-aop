package com.example.assignment3.dto;

import com.example.assignment3.entity.Product;
import com.example.assignment3.entity.User;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class ReviewDto {
    private int id;
    private String comment;
    private Product product;
    private User user;
}
