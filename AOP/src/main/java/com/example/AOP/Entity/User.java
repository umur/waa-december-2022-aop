package com.example.AOP.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "user_tbl")
public class User {
    @Id
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToOne(mappedBy="user")
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;
}
