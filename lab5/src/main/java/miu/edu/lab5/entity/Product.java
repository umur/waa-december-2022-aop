package miu.edu.lab5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    private int id;
    private String name;
    private int rating;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Review reviews;

}
