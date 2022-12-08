package edu.miu.labthree.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "addresses")
public class Address {
    @Id
    private int id;
    private String street;
    private String city;
    private int zip;



}
