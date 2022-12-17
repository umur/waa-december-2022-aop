package edu.miu.lab32.model.dto;

import edu.miu.lab32.model.entity.Product;
import lombok.Data;

@Data
public class ReviewDTO {
    private int id;
    private String comment;
    private Product product;
}
