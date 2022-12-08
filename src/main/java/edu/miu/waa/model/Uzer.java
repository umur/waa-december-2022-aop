package edu.miu.waa.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Uzer {

    @Id
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToOne
    // @JoinColumn//(name = "address_id")
    @JsonManagedReference
    private Address address;

    @OneToMany(mappedBy = "uzer")
    @JsonBackReference
    private List<Review> reviews;
}
