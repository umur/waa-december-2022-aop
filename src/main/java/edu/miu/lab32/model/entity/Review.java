package edu.miu.lab32.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

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
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

}
