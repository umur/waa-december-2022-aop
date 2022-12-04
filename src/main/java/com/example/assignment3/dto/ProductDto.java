package com.example.assignment3.dto;

import com.example.assignment3.entity.Category;
import lombok.Data;

@Data
public class ProductDto {
    private int id;

    private String name;
    private float price;
    private float rating;
    private CategoryDto category;
}
