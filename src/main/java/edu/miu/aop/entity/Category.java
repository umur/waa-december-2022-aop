package edu.miu.aop.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Ankhbayar Azzaya
 */
@Entity
@Data
public class Category {
    @Id
    private int id;
    private String name;
    private boolean deleted;

    @JsonManagedReference
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    List<Product> products;
}
