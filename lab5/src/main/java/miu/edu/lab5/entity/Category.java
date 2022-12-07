package miu.edu.lab5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Category {
    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
