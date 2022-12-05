package edu.miu.aop.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
@Data
public class ProductDto {
    private int id;
    private String name;
    private int price;
    private int rating;
    private List<ReviewDto> reviews;
}
