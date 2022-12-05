package miu.edu.springaop.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isDeleted;


   @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Review> reviews;



    //   @OneToOne(cascade = CascadeType.MERGE)
     @JsonManagedReference
    @OneToOne(mappedBy = "user")
    private Address address;
}
