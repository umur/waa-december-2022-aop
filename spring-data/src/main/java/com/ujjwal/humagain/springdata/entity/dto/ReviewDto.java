package com.ujjwal.humagain.springdata.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ujjwal.humagain.springdata.entity.Product;
import com.ujjwal.humagain.springdata.entity.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class ReviewDto {
    private int id;
    private String comment;
    @JsonIgnore
    private ProductDto product;
    @JsonIgnore
    private UserDto user;
}
