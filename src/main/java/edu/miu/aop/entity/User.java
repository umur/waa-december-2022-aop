package edu.miu.aop.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    private int id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private boolean deleted;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    @OneToOne
    private Address address;
}
