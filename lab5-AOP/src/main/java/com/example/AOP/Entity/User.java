package com.example.AOP.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import java.util.List;

@Entity
@Data
@Table(name = "user_table")
public class User {
    @Id
    private  int id;
    private VarcharJdbcType email;
    private VarcharJdbcType password;
    private String firstName;
    private String lastName;
    @OneToMany
    List<Review> reviews;

    @OneToOne
    private Address address;

}
