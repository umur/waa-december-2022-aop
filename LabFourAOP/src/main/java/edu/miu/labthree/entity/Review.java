package edu.miu.labthree.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "reviews")
public class Review {
    @Id
    private int id;
    private int comment;

    @ManyToOne
    private Product product;
    @ManyToOne
    private User user;




}
