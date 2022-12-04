package com.example.assignment3.dto;

import com.example.assignment3.entity.User;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
public class AddressDto {
    private int id;
    private String street;
    private int zip;
    private String city;
//    private User user;
}
