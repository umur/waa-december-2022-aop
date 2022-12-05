package miu.edu.springaop.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    private int id;

    private String comment;

    @Embedded
    private AuditFields auditFields;

    @JsonBackReference
    @ManyToOne
    private Product product;

    @JsonBackReference
    @ManyToOne
    private User user;
}
