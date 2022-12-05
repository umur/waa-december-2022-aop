package edu.miu.aop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
@Entity
@Data
public class Product {

    @Id
    private int id;
    private String name;
    private int price;
    private int rating;
    private boolean deleted;

    @JsonBackReference
    @ManyToOne
    private Category category;

    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
}
