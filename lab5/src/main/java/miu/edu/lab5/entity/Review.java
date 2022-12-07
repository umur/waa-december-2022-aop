package miu.edu.lab5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Review {

    @Id
    private int id;
    private String comment;

    @OneToMany (mappedBy = "reviews")
    private List<Product> product;

    @ManyToOne
    private User user;

}
