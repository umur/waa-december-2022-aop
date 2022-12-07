package com.example.AOP.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="categorie_tbl")
public class Category {
    @Id
    private int id;
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
