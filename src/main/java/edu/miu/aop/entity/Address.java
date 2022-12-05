package edu.miu.aop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

/**
 * @author Ankhbayar Azzaya
 */
@Entity
@Data
public class Address {
    @Id
    private int id;
    private String street;
    private int zip;
    private String city;
    private boolean deleted;

    @OneToOne(mappedBy = "address")
    private User user;
}
