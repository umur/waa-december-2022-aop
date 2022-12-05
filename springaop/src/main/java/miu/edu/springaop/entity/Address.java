package miu.edu.springaop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    private int id;

    private String street;
    private int zip;
    private String city;

    //    @OneToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    @OneToOne
    private User user;


    @Embedded
    private AuditFields auditFields;
}
