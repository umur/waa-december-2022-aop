package edu.miu.lab32.model.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private int id;
    private String name;
    private double price;
    private int rating;
}