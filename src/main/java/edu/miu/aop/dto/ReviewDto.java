package edu.miu.aop.dto;

import edu.miu.aop.entity.Product;
import edu.miu.aop.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
public class ReviewDto {
    private int id;
    private String comment;

    @JsonIgnoreProperties("reviews")
    private ProductDto product;

    @JsonIgnoreProperties("reviews")
    private UserDto user;
}
