package edu.miu.aop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * @author Ankhbayar Azzaya
 */
@Entity
@Data
public class Review {
    @Id
    private int id;
    private String comment;

    @JsonBackReference
    @ManyToOne
    private Product product;

    @JsonBackReference
    @ManyToOne
    private User user;
}
