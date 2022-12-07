package miu.edu.lab5.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street;
    private int zip;
    private String city;

    @OneToOne
    private User user;
}
