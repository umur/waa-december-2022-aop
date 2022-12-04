package com.example.assignment3.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Product {
    @Id
    private int id;

    private String name;
    private float price;
    private float rating;

    @ManyToOne()
    @JsonBackReference
    private Category category;
}
