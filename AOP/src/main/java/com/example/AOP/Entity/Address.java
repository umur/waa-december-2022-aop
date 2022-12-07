package com.example.AOP.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="address_tbl")
public class Address {
    @Id
    private int id;
    private String street;
    private String zip;
    private String city;
    @OneToOne
    private User user;
}
