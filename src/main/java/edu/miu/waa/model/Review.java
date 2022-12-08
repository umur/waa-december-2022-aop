package edu.miu.waa.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

//@Table(name = "REVIEW")
@Data
@Entity
public class Review {

    @Id
    private int id;

    // @Column(name = "COMMENT", updatable = false, insertable = false)
    // updateable - it don't will be updated in generated update query
    @Column // (name = "COMMENT")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonManagedReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "uzer_id")
    @JsonManagedReference
    private Uzer uzer;

}
