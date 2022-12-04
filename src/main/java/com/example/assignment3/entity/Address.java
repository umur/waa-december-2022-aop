package com.example.assignment3.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Address {
    @Id
    private int id;

    private String street;
    private int zip;
    private String city;

    @OneToOne
    private User user;
}
