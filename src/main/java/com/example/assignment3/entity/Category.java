package com.example.assignment3.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    private int id;

    private String name;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Product> products;
}
