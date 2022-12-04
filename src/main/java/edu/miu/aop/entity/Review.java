package edu.miu.aop.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Review {
    @Id
    private int id;

    private String comment;

    //A Review can only belong to one Product.
    @ManyToOne
    private Product product;

    //A Review can only belong to one User.
    @ManyToOne(cascade = CascadeType.MERGE)
    private User user;
}
