package com.example.assignment3.dto;

import com.example.assignment3.entity.Address;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
public class UserDto {
    private int id;
    private String email;
//    private String password;
    private String firstname;
    private String lastname;
    private Address address;
}
