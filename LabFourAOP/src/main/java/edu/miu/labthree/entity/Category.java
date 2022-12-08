package edu.miu.labthree.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name = "Categories")
public class Category {
    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> productsList;
}
