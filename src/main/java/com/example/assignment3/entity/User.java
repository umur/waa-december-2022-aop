package com.example.assignment3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name = "users")
@Data
public class User {
    @Id
    private int id;

    private String email;
    private String password;
    private String firstname;
    private String lastname;

    @OneToOne(mappedBy = "user")
    @JsonIgnore
    private Address address;
}
