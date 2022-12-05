package miu.edu.springaop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Product {

    @Id
    private int id;

    @Column
    private String name;
    private double price;
    private boolean isDeleted;

    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List<Review> reviews;

    @JsonBackReference
    @ManyToOne
    private Category category;


    @Embedded
    private AuditFields auditFields;


}
