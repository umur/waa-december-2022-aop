package com.example.assignment3.dto;

import com.example.assignment3.entity.Product;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    private int id;
    private String name;
    private List<Product> products;
}
